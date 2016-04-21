package Project1;

/**
 * MoveToward class that extend ActionNode that indicate the Wumpus can see the
 * target and move towards it
 * 
 * @author Aoyi Li
 */
final class MoveToward extends ActionNode {
	/** Represent the Wumpus */
	private Character Me;
	/** Represent the Object you want to catch */
	private Character Target;

	/** Constructor */
	public MoveToward(Character me, Character target) {
		this.Me = me;
		this.Target = target;
	}

	/** return a string which indicate the move towards action */
	@Override
	protected String getAction() {
		return Me.getName() + " moves towards " + Target.getName();
	}
}