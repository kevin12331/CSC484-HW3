import processing.core.PApplet;

public class DecisionTree {

	private DecisionTreeNode StartNode;
	private DecisionNode canSee, haveChomp, inRange;

	private ActionNode search;
	private ActionNode chase, eat;
	private ActionNode getTeeth;
	
	
	public DecisionTree(Character agent, Character monster, PApplet parent) {

		canSee = new canSee( agent, monster );
		haveChomp = new haveChomp( monster );
		inRange = new inRange( agent, monster );
		
		search = new Wander(monster, parent);
		chase = new Arrive(agent, monster);
		eat = new Eat(monster, agent, parent);
		getTeeth = new getTeeth( new Character(700,700,0,0,parent), monster);
		
		haveChomp.setFalse(getTeeth);
		haveChomp.setTrue(canSee);

		canSee.setFalse(search);
		canSee.setTrue(inRange);
		
		inRange.setFalse(chase);
		inRange.setTrue(eat);

		StartNode = haveChomp;
	}
	
	public Steering getAction() {
		return ((ActionNode) StartNode.makeDecision()).getAction();
	}
	
}
