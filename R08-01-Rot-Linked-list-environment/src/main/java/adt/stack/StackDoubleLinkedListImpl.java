package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (element != null) {
			if (isFull()) {
				throw new StackOverflowException();
			} else {
				top.insert(element);
			}
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}

		T res = ((DoubleLinkedListImpl<T>) top).getLast().getData();
		top.removeLast();
		return res;
		
	}

	@Override
	public T top() {
		T res = null;
		if (!isEmpty()) {
			res = ((DoubleLinkedListImpl<T>) top).getLast().getData();
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (top.isEmpty()) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		boolean res = false;
		if (top.size() == size) {
			res = true;
		}
		return res;
	}

}
