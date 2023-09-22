package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {
			if (isFull()) {
				throw new QueueOverflowException();
			}
			list.insert(element);
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (list.isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T res = ((DoubleLinkedListImpl<T>) list).getHead().getData();
		list.removeFirst();
		return res;
	}

	@Override
	public T head() {
		T res = null;
		if (!isEmpty()) {
			res = ((DoubleLinkedListImpl<T>) list).getHead().getData();
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (list.isEmpty()) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		boolean res = false;
		if (list.size() == size) {
			res = true;
		}

		return res;
	}

}
