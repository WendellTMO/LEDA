package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		try {
			stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		moveToStack2();
		
		T res = null;
		try {
			res = stack2.pop();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
		
		}
		moveToStack1();
		
		return res;
		
	}

	@Override
	public T head() {
		T res = null;
		if (!isEmpty()) {
			moveToStack2();
			res = stack2.top();
			moveToStack1();
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		boolean res = stack1.isEmpty();
		return res;
	}

	@Override
	public boolean isFull() {
		boolean res = stack1.isFull();
		return res;
	}

	private void moveToStack1(){
		while(!stack2.isEmpty()) {
			T elementStack2 = null;

			try {
				elementStack2 = stack2.pop();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}

			try {
				stack1.push(elementStack2);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}

	}

	private void moveToStack2(){
		while(!stack1.isEmpty()) {
			T elementStack1 = null;
			try {
				elementStack1 = stack1.pop();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}

			try {
				stack2.push(elementStack1);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

}
