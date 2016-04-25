import java.io.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class ID3 {
	
	LinkedList<Example> examples;
	LinkedList<String> attributes;

	File file;
	
	public ID3( File file ){
		
		this.file = file;	
		attributes.add("nikesOn");
		attributes.add("seeNikes");
		attributes.add("seeDoor");
		attributes.add("nearDoor");
		attributes.add("doorLocked");
		attributes.add("doorOpen");
		
	}
	
	void printExamples(){
		for(Example e : examples){
			Iterator<Entry<String, Boolean>> i = e.attributes.entrySet().iterator();
			while(i.hasNext()){
				System.out.print(i.next().getValue());
				System.out.print(" ");
			}
			System.out.println(e.action);
		}
			
	}
	
	void makeTree( LinkedList<Example> examples, LinkedList<String> attributes, DecisionNode decisionNode  ){
		
		int initialEntropy = entropy(examples);
		
		if(initialEntropy <=0 )
			return;
		
		int exampleCount = examples.size();
		
		int bestInformationGain = 0;
		String bestSplitAttribute = "";
		Hashtable<Boolean, LinkedList<Example>> bestSets;
		
		for(String attribute: attributes){
			Hashtable<Boolean, LinkedList<Example>> sets = splitByAttribute(examples, attribute);
			int overallEntropy = entropyOfSets(sets, exampleCount);
			int informationGain = initialEntropy - overallEntropy;
			
			if (informationGain > bestInformationGain){
				bestInformationGain = informationGain;
				bestSplitAttribute  = attribute;
				bestSets = sets;
			}
			
			//TODO
		}
		
			
	}
	
	void readFile(){
		BufferedReader reader = null;
		LinkedList<Example> examples = new LinkedList<Example>();

        try { 
           FileInputStream f = new FileInputStream(file); 
           reader = new BufferedReader(new InputStreamReader(f));;
           
           // read the first record of the file
           String line;
           Hashtable<String, Boolean> attributes;
           
           
           while ((line = reader.readLine()) != null) {
              StringTokenizer st = new StringTokenizer(line);
              attributes = new Hashtable<String, Boolean>();
              	
			  String nikesOn = st.nextToken();
			  String seeNikes = st.nextToken();
			  String seeDoor = st.nextToken();
			  String nearDoor = st.nextToken();
			  String doorLocked = st.nextToken();
			  String doorOpen = st.nextToken();
			  String action = st.nextToken();
			  
			  if(nikesOn.equals("true")){
				  attributes.put("nikesOn", true);
			  }else{
				  attributes.put("nikesOn", false);
			  }
			  
			  if(seeNikes.equals("true")){
				  attributes.put("seeNikes", true);
			  }else{
				  attributes.put("seeNikes", false);
			  }
			  
			  if(seeDoor.equals("true")){
				  attributes.put("seeDoor", true);
			  }else{
				  attributes.put("seeDoor", false);
			  }
			  
			  if(nearDoor.equals("true")){
				  attributes.put("nearDoor", true);
			  }else{
				  attributes.put("nearDoor", false);
			  }
			  
			  if(doorLocked.equals("true")){
				  attributes.put("doorLocked", true);
			  }else{
				  attributes.put("doorLocked", false);
			  }
			  
			  if(doorOpen.equals("true")){
				  attributes.put("doorOpen", true);
			  }else{
				  attributes.put("doorOpen", false);
			  }
			  
			  //TODO: CODE FOR ADDING ACTIONNODE TO EXAMPLE AND REPLACE NULL BELOW
			  
			  examples.add(new Example(attributes, action));
           }
           this.examples = examples;

        } 
        catch (IOException e) { 
           System.out.println("Uh oh, got an IOException error: " + e.getMessage()); 
        } 
        catch (Exception e) {
            System.out.println("Uh oh, got an Exception error: " + e.getMessage()); 
        }
	}
	
	
	//Returns the entropy of a given set of lists of examples
	int entropyOfSets(Hashtable<Boolean, LinkedList<Example>> sets, int exampleCount ){
		int entropy = 0;
		
		Iterator<Entry<Boolean, LinkedList<Example>>> iterator = sets.entrySet().iterator();
		while(iterator.hasNext()){
			LinkedList<Example> examples = iterator.next().getValue();
			int proportion = examples.size() / exampleCount;
			entropy -= proportion * entropy(examples);
		}
		return entropy;
	}
	
	// Puts the examples into lists based on true or false (per attribute), then adds both lists to a Hashtable indexed by true/false
	Hashtable<Boolean, LinkedList<Example>> splitByAttribute( LinkedList<Example> examples, String attribute ) {
		Hashtable<Boolean, LinkedList<Example>> sets = new Hashtable<Boolean, LinkedList<Example>>();
		
		LinkedList<Example> setTrue = new LinkedList<Example>();
		LinkedList<Example> setFalse = new LinkedList<Example>();
		
		sets.put(true, setTrue);
		sets.put(false, setFalse);
		
		for( Example e : examples ){
			if(e.getValue(attribute) == true ){
				setTrue.add(e);
			}
			else{
				setFalse.add(e);
			}
		}
		
		return sets;
		
	}
	
	//Get the entropy of the list of examples
	int entropy( LinkedList<Example> examples ){
		
		Hashtable<String, AtomicInteger> actionTallies = new Hashtable<String, AtomicInteger>();
		
		actionTallies.put("grabPlayer", new AtomicInteger(0));
		actionTallies.put("bargeIn", new AtomicInteger(0));
		actionTallies.put("moveToDoor", new AtomicInteger(0));
		actionTallies.put("moveToNikes", new AtomicInteger(0));
		actionTallies.put("Search", new AtomicInteger(0));

		
		int exampleCount = examples.size();
		
		if (exampleCount == 0)
			return 0;
				
		for( Example e : examples ){
			actionTallies.get(e.action).incrementAndGet();
		}
		
		int actionCount = actionTallies.size();
		
		if(actionCount == 0)
			return 0;
		
		int entropy = 0;
		
		Iterator<Entry<String, AtomicInteger>> iterator = actionTallies.entrySet().iterator();
		
		while(iterator.hasNext()){
			int proportion = iterator.next().getValue().get() / exampleCount;
			entropy -= proportion * log2(proportion);
			
		}
		
		return entropy;
		
	}
	
	//Helper function for entropy
	int log2(float x){
		return (int) (Math.log(x) / Math.log(2));
	}
	
	//The Example data structure
	class Example{
		String action;
		Hashtable<String, Boolean> attributes;
		
		public Example(Hashtable<String, Boolean> attributes, String action){
			this.attributes = attributes;
			this.action = action;
		}
		
		Boolean getValue(String attribute){
			return attributes.get(attribute);
		}
	}

	
}
