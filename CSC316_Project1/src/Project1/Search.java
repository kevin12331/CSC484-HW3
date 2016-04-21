package Project1;

/**
 * Search class that extend ActionNode that indicate the Wumpus can't see the
 * target and randomly search the enviroment
 * 
 * @author Aoyi Li
 */
final class Search extends ActionNode {
	/** Represent the Wumpus */
	private Character Me;

	/** Constructor */
	public Search(Character me) {
		this.Me = me;
	}

	/** return a string which indicate the search action */
	@Override
	protected String getAction() {
		return Me.getName() + " searchs";
	}
}
