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
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
				aux.setData(getData());
				aux.setNext(getNext());
				aux.setPrevious(getPrevious());
				setData(element);
				setNext(aux);
			}	
		}
		
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			if(getNext().isEmpty() ) {
				RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>();
				setData(aux.getData());
				setNext(aux.getNext());
				
			} else {
				setData(getNext().getData());
				setNext(getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(getPrevious());
			}

		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if (getNext().isEmpty()) {
				setData(getNext().getData());
				setNext(getNext().getNext());
				getPrevious().setNext(getNext());
			} else {
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
			}
		}

	}

	@Override
	public void insert(T element) {
		if (element != null) {
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
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
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
