import java.util.StringTokenizer;

public class Converter {

	String inFixExpression;
	StringTokenizer tokenizer;
	ArrayStack stack;
	String output = "";
	String token;
	String temp;
	int test;
	
	public Converter(String inFixExpression) {
		//this.inFixExpression = inFixExpression.replaceAll("\\s+", "");
		this.inFixExpression = inFixExpression;
		this.tokenizer = new StringTokenizer(this.inFixExpression, ".");
		this.stack = new ArrayStack();
	}
	
	public String toPostFix() throws InFixException, StackUnderflowException, StackOverflowException {
		while (this.tokenizer.hasMoreTokens()) {
			this.token = this.tokenizer.nextToken();
			
			if (isNotOperator(this.token)) {
				try {
					this.test = Integer.parseInt(this.token);
					this.output += this.test;
					this.output += ".";
				}
				catch (NumberFormatException badData) {
					throw new InFixException("Illegal symbol: " + badData.getMessage());
				}
				if (this.stack.isFull()) 
					throw new InFixException("Too many operators - stack overflow");
				}
			else {
				switch (this.token) {
				case "(":
					this.stack.push(this.token);
					break;
				case ")":
					while (!this.stack.isEmpty()) {
						if (this.stack.top().equals("(")) {
							this.stack.pop();
							break;
						}
						else {
							this.temp = (String)this.stack.top();
							this.output += this.temp;
							this.output += ".";
							this.stack.pop();	
						}
					}
					break;
				case "+":
					while (!this.stack.isEmpty()) {
						if (this.stack.top().equals("*") || this.stack.top().equals("/") || this.stack.top().equals("^") || this.stack.top().equals("-")) {
							this.temp = (String)this.stack.top();
							this.output += this.temp;
							this.output += ".";
							this.stack.pop();
						}
						else
							break;
					}
					this.stack.push(this.token);
					break;
				case "-":
					while (!this.stack.isEmpty()) {
						if (this.stack.top().equals("*") || this.stack.top().equals("/") || this.stack.top().equals("^") || this.stack.top().equals("+")) {
							this.temp = (String)this.stack.top();
							this.output += this.temp;
							this.output += ".";
							this.stack.pop();
						}
						else
							break;
					}
					this.stack.push(this.token);
					break;
				case "*":
					while (!this.stack.isEmpty()) {
						if (this.stack.top().equals("^") || this.stack.top().equals("/")) {
							this.temp = (String)this.stack.top();
							this.output += this.temp;
							this.output += ".";
							this.stack.pop();
						}
						else
							break;
					}
					this.stack.push(this.token);
					break;
				case "/":
					while (!this.stack.isEmpty()) {
						if (this.stack.top().equals("^") || this.stack.top().equals("*")) {
							this.temp = (String)this.stack.top();
							this.output += this.temp;
							this.output += ".";
							this.stack.pop();
						}
						else
							break;
					}
					this.stack.push(this.token);
					break;
				case "^":
					this.stack.push(this.token);
					break;
				case ".":
					break;
				}
			}
		}
		while (!this.stack.isEmpty()) {
			this.temp = (String)this.stack.top();
			this.output += this.temp;
			this.output += ".";
			this.stack.pop();
		}
		
		System.out.println(output);
		return this.output;
	}
	
	public static boolean isNotOperator(String test) {
		if (test.equals("/") || test.equals("*") || test.equals("-") || test.equals("+") || test.equals("^") ||
				test.equals("(") || test.equals(")") || test.equals("{") || test.equals("}"))
			return false;
		else
			return true;
	}
}
