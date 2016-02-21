import java.util.StringTokenizer;

public class PostFixToExpressionTree {

	String postFixExpression;
	BSTStack stack;
	
	public PostFixToExpressionTree(String postFixExpression){
		this.postFixExpression = postFixExpression;
		this.stack = new BSTStack();
	}


	
	public BSTNode convert() throws StackOverflowException, StackUnderflowException {
		BSTNode root = null;
		String token;
		StringTokenizer tokenizer = new StringTokenizer(postFixExpression, ".");
		
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();

			if (isNotOperator(token)){
				BSTNode node = new BSTNode(token);
				stack.push(node);
			}
			else {
				BSTNode node = new BSTNode(token);
				BSTNode temp = stack.top();
				node.right = temp;
				stack.pop();
				temp = stack.top();
				node.left = temp;
				stack.pop();
				stack.push(node);
				root = stack.top();
			}
		}
		
		return root;
	}
	
	public static boolean isNotOperator(String test) {
		if (test.equals("/") || test.equals("*") || test.equals("-") || test.equals("+") || test.equals("^") ||
				test.equals("(") || test.equals(")") || test.equals("{") || test.equals("}") || test.equals("."))
			return false;
		else
			return true;
	}
}
