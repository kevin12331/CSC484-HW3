package Project1;

/**
 * IsVisible class that extend ActionNode to check if Wumpus is able to see the
 * target
 * 
 * @author Aoyi Li
 */
final class IsVisible extends DecisionNode {
	/** Represent the Wumpus */
	private Character Me;
	/** Represent the Object you want to catch */
	private Character Target;

	/** Constructor */
	public IsVisible(Character me, Character target) {
		this.Me = me;
		this.Target = target;
	}

	/**
	 * check if player and see the target
	 * 
	 * @return true if in the same x-axes or y-axes, false otherwise
	 * 
	 */
	@Override
	protected boolean isTrue() {
		//check if in x-axes or y-axes
		if (Me.getX() == Target.getX() || Me.getY() == Target.getY()) {
			return true;
		}
		return false;
	}
}