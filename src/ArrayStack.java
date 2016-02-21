public class ArrayStack implements StackInterface {

	private String[] stack;
	private int topIndex = -1;
	
	public ArrayStack() {
		stack = new String[100];
	}
	
	public ArrayStack(int maxSize) {
		stack = new String[maxSize];
	}
	
	public void push(String item) throws StackOverflowException {
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = item;
		}
		else
			throw new StackOverflowException("Push attempted on a full stack.");
	}

	@Override
	public void pop() throws StackUnderflowException {
		if (!isEmpty()) {
			stack[topIndex] = null;
			topIndex--;
		}
		else
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}

	@Override
	public String top() throws StackUnderflowException {
		String topOfStack = null;
		if(!isEmpty())
			topOfStack = stack[topIndex];
		else
			throw new StackUnderflowException("Top attempted on an empty stack.");
		return topOfStack;
	}

	@Override
	public boolean isEmpty() {
		if (topIndex == -1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFull() {
		if (topIndex == (stack.length - 1))
			return true;
		else
			return false;
	}

}
