package Project1;

/**
 * IsColocated class that extend ActionNode to check if player and Wumpus are in
 * the same location
 * 
 * @author Aoyi Li
 */
final class IsColocated extends DecisionNode {
	/** Represent the Wumpus */
	private Character Me;
	/** Represent the Object you want to catch */
	private Character Target;

	/** Constructor */
	public IsColocated(Character me, Character target) {
		this.Me = me;
		this.Target = target;
	}

	/**
	 * check if player and target are in the same location
	 * 
	 * @return true if Co-located, False otherwise
	 * 
	 */
	@Override
	protected boolean isTrue() {
		// if x and y coordinates equals at the same time, that means Co-located
		if (Me.getX() == Target.getX() && Me.getY() == Target.getY()) {
			return true;
		}
		return false;
	}
}