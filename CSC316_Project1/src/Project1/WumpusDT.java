package Project1;

/**
 * Class that build Wumpus' decision tree
 * 
 * @author Aoyi Li
 *
 */
public class WumpusDT {
	// Declare all the object in the decision tree
	private Character Wumpus;
	private Character Player;
	private DecisionTreeNode StartNode;
	private DecisionNode isVisible;
	private DecisionNode isColocated;
	private ActionNode search;
	private ActionNode moveToward;
	private ActionNode grab;

	/** Constructor */
	public WumpusDT(WorldState state) {
		// error handling, if either Wumpus/Player not in the game environment,
		// error message comes up and exit the program
		if (state.getCharacter("Wumpus") == null) {
			System.out.print("There's no Wumpus in the game !");
			System.exit(1);
		}
		if (state.getCharacter("Player") == null) {
			System.out.print("There's no Player in the game !");
			System.exit(1);
		}

		// Get two Character object
		this.Wumpus = state.getCharacter("Wumpus");
		this.Player = state.getCharacter("Player");

		// initiate all the nodes in the decision tree
		isVisible = new IsVisible(Wumpus, Player);
		isColocated = new IsColocated(Wumpus, Player);
		search = new Search(Wumpus);
		moveToward = new MoveToward(Wumpus, Player);
		grab = new Grab(Wumpus, Player);

		// set up the decision tree
		isVisible.setFalse(search);
		isVisible.setTrue(isColocated);
		isColocated.setFalse(moveToward);
		isColocated.setTrue(grab);

		// I set a star Node here just to be more clear about the structure
		StartNode = isVisible;
	}

	/**
	 * get the String which represent the action from the leaf action node based
	 * on the World state
	 */
	public String getAction() {
		return ((ActionNode) StartNode.makeDecision()).getAction();
	}
}
