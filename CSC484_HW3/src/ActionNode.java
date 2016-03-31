


public abstract class ActionNode implements DecisionTreeNode {
	String getAction() {
		return null; 
	}

	public DecisionTreeNode makeDecision() {
		return this;
	}

}
