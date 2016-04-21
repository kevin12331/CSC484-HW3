package Project1;

/**
 * DecisionNode object which implements DecisionTreeNode
 * 
 * @author Aoyi Li
 *
 */
public abstract class DecisionNode implements DecisionTreeNode {
	/** TrueNode in the decisionTree */
	private DecisionTreeNode TrueNode;
	/** FalseNode in the decisionTree */
	private DecisionTreeNode FalseNode;

	/**
	 * check which decision node should go to next will be override later by
	 * child class
	 */
	boolean isTrue() {
		return false;
	}

	/** set TrueNode in the decisionTree */
	void setTrue(DecisionTreeNode trueNode) {
		this.TrueNode = trueNode;
	}

	/** set FalseNode in the decisionTree */
	void setFalse(DecisionTreeNode falseNode) {
		this.FalseNode = falseNode;
	}

	/** return trueNode or FalseNode based on isTrue() */
	DecisionTreeNode getBranch() {
		if (isTrue()) {
			return TrueNode;
		}
		return FalseNode;
	}

	/** recursive called make decision until its a leaf node */
	public DecisionTreeNode makeDecision() {
		// this check actually is not necessary because the decision node will
		// not be the leaf node cause it make decision that leads to next
		// decision or action, I put here just for error handling (incorrect
		// build of decision tree etc)
		if (this.TrueNode == null && this.FalseNode == null) {
			System.out.println("Error: DecisionNode should always leads to next Decision or Action");
			System.exit(0);
		} else {
			return this.getBranch().makeDecision();
		}
		return null;
	}

}
