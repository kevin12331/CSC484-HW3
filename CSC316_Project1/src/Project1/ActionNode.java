package Project1;

/**
 * Action node class that implements DecisionTreeNode
 * 
 * @author Aoyi Li
 *
 */
public abstract class ActionNode implements DecisionTreeNode {
	//will be override by specific children of ActionNode
	String getAction() {
		return null; 
	}

	public DecisionTreeNode makeDecision() {
		return this;
	}

}
