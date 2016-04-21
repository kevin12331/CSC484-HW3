
public class haveChomp extends DecisionNode {

	private Character monster;
	
	public haveChomp( Character monster ) {

		this.monster = monster;
	}
	
	@Override
	protected boolean isTrue() {
		//check if in x-axes or y-axes
		return monster.chompers;
		
	}

}
