package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		if(head == -1) {
			head++;
		}

		tail = (tail + 1) % array.length;
		array[tail] = element;
		elements += 1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T res = array[head];
		head = (head + 1) % array.length;
		elements -= 1;

		return res;
	}

	@Override
	public T head() {
		T res = null;
		if (!isEmpty()) {
			res = array[head];
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (elements == 0) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		boolean res = false;
		if (elements == array.length) {
			res = true;
		}
		return res;
	}

}
