package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		
		T res = null;
		if (!isEmpty()) {
			res = array[top];
		} 
		return res;

	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (top == -1) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		boolean res = false;
		if (top == array.length - 1) {
			res = true;
		}		
		return res;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		array[++top] = element;

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();	
		}
		T res = array[top--];
		return res;
	}

}
