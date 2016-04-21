import processing.core.PApplet;

public class Search extends Task {
	
	Map map;
	Wander wander;
	
	public Search(Map map, PApplet parent ){
		this.map = map;
		wander = new Wander( map.characters.getLast(), parent );
		
	}
	

	@Override
	public boolean run(float time, Map map ) {
		
		    map.characters.getLast().update(wander.getAction(), time);
			return true;
	}
}
