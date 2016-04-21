

final class canSee extends DecisionNode {
	private Character agent;
	private Character monster;
	private int RANGE = 300;
	
	public canSee(Character agent, Character monster) {
		this.agent = agent;
		this.monster = monster;
	}
	
	@Override
	protected boolean isTrue() {
		//check if in x-axes or y-axes
		if ((int) Math.sqrt(Math.pow(agent.position.x - monster.position.x, 2)
				+ Math.pow(agent.position.y - monster.position.x, 2)) <= RANGE)
			return true;
		

			
		
		return false;
	}
}
