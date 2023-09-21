package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			if (isEmpty()) {
				insert(element);
			} else {
				getPrevious().setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				getPrevious().setData(element);
				getPrevious().setNext(getNext());
			}	
		}
		
	}

	@Override
	public void removeFirst() {

	}

	@Override
	public void removeLast() {

	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			setData(element);
			setNext(new RecursiveDoubleLinkedListImpl<T>());
			if(getPrevious() == null) {
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			}
		} else {
			getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (getData().equals(element)) {
				if(getPrevious().isEmpty() && getNext().isEmpty()) {
					setNext(getNext());
					setPrevious(getPrevious());
				}

				setData(getNext().getData());
				setNext(getNext().getNext());
				if (getNext() != null) {
					((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(getPrevious());
				}
			} else {
				getNext().remove(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
