
public class BSTTree {

	BSTNode root;
	String preFixExpression;
	String inFixExpression;
	String postFixExpression;
	
	public BSTTree(BSTNode root){
		this.root = root;
		this.preFixExpression = "";
		this.inFixExpression = "";
		this.postFixExpression = "";
	}

	public BSTNode getRoot() {
		return this.root;
	}
	
	public String InOrder(BSTNode root) {
		if (root == null) {
			return this.inFixExpression;
		}
		
		this.inFixExpression += "(";
		InOrder(root.left);
		
		this.inFixExpression += root.data;

		InOrder(root.right);
		this.inFixExpression += ")";
		
		return this.inFixExpression;
	}
	
	public String PreOrder(BSTNode root) {
		if (root == null) {
			return this.preFixExpression;
		}
		
		this.preFixExpression += root.data;
		this.preFixExpression += ".";
		PreOrder(root.left);
		PreOrder(root.right);
		
		return this.preFixExpression;
	}
	
	public String PostOrder(BSTNode root) {
		if (root == null) {
			return this.postFixExpression;
		}
		
		PostOrder(root.left);
		PostOrder(root.right);
		this.postFixExpression += root.data;
		this.postFixExpression += ".";

		return this.postFixExpression;
	}
}
