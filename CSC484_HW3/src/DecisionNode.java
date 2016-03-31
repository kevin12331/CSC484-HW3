

public abstract class DecisionNode implements DecisionTreeNode {

	private DecisionTreeNode TrueNode;

	private DecisionTreeNode FalseNode;


	boolean isTrue() {
		return false;
	}

	void setTrue(DecisionTreeNode trueNode) {
		this.TrueNode = trueNode;
	}

	void setFalse(DecisionTreeNode falseNode) {
		this.FalseNode = falseNode;
	}

	DecisionTreeNode getBranch() {
		if (isTrue()) {
			return TrueNode;
		}
		return FalseNode;
	}

	public DecisionTreeNode makeDecision() {

		if (this.TrueNode == null && this.FalseNode == null) {
			System.out.println("Error: DecisionNode should always leads to next Decision or Action");
			System.exit(0);
		} else {
			return this.getBranch().makeDecision();
		}
		return null;
	}

}
