package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (getData() == null) {
			res = true;
		}
		return res;
	}

	@Override
	public int size() {
		int res = 0;
		if (isEmpty()) {
			res = 0;
		} else {
			res = 1 + getNext().size();
		}
		return res;
	}

	@Override
	public T search(T element) {
		T res = null;
		if (!isEmpty()) {
			if (getData().equals(element)) {
				res = getData();
			} else {
				res = getNext().search(element);
			}
		}
		return res;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if(getData().equals(element)) {
				setData(getNext().getData());
				setNext(getNext().getNext());
			} else {
				getNext().remove(element);
			}
		}

	}

	@Override
	public T[] toArray() {
		int size = size();
		T[] result = (T[]) new Object[size];
		toArrayAuxiliar(result, 0);

		return result;
	}

	private void toArrayAuxiliar(Object[] array, int i) {
		if (!isEmpty()) {
			array[i] = getData();
			getNext().toArrayAuxiliar(array, i + 1);
		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
