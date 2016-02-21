public interface StackInterface {

	public void push(String node) throws StackOverflowException;
	
	public void pop() throws StackUnderflowException;
	
	public String top() throws StackUnderflowException;
	
	public boolean isEmpty();
	
	public boolean isFull();
}
