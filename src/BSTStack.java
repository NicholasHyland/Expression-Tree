public class BSTStack implements BSTStackInterface{

		private BSTNode[] stack;
		private int topIndex = -1;
		
		public BSTStack() {
			stack = new BSTNode[100];
		}
		
		public BSTStack(int maxSize) {
			stack = new BSTNode[maxSize];
		}
		
		public void push(BSTNode item) throws StackOverflowException {
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
		public BSTNode top() throws StackUnderflowException {
			BSTNode topOfStack = null;
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
