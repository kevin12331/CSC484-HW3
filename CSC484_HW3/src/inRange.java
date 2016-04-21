
public class inRange extends DecisionNode {
	private Character agent;
	private Character monster;
	private float RANGE = 40;
	
	public inRange(Character agent, Character monster) {
		this.agent = agent;
		this.monster = monster;
	}
	
	
	@Override
	protected boolean isTrue() {
		//check if in x-axes or y-axes
		if( (float) Math.sqrt(   Math.pow(monster.position.x - agent.position.x, 2) + Math.pow(monster.position.x - agent.position.x, 2)   )   <= RANGE ) 
			return true; 
		
		
				  
		
		return false;
	}
}
