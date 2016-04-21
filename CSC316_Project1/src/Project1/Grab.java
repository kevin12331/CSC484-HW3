package Project1;

/**
 * Grab class that extend ActionNode indicate the Wumpus catches target
 * 
 * @author Aoyi Li
 */
final class Grab extends ActionNode {
	/** Represent the Wumpus */
	private Character Me;
	/** Represent the Object you want to catch */
	private Character Target;

	/** Constructor */
	public Grab(Character me, Character target) {
		this.Me = me;
		this.Target = target;
	}

	/** return a string which indicate the grab move 
	 */
	@Override
	protected String getAction() {
		return Me.getName() + " grabs " + Target.getName();
	}
}
