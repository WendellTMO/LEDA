package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T res = null;
		if (!isEmpty()) {
			res = array[0];
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if(tail == -1) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		boolean res = false;
		if (tail == array.length - 1) {
			res = true;
		}
		return res;
	}

	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
			T temp_element = array[i++];
			array[i] = temp_element;
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		array[++tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T res = array[0];
		shiftLeft();
		tail--;
		return res;
	}

}
