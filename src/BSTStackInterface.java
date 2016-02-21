public interface BSTStackInterface {
	
		public void push(BSTNode node) throws StackOverflowException;
		
		public void pop() throws StackUnderflowException;
		
		public BSTNode top() throws StackUnderflowException;
		
		public boolean isEmpty();
		
		public boolean isFull();
	
}
