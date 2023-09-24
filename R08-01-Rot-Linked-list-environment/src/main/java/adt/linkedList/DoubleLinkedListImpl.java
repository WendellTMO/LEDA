package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = new DoubleLinkedListNode<T>();
	}

	@Override
	public void insertFirst(T element) {
		if (!element.equals(null)) {
			
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>();
			newHead.setData(element);
			newHead.setNext(getHead());
			((DoubleLinkedListNode<T>) getHead()).setPrevious(newHead);

			if(getLast().isNIL()) {
				setLast(newHead);
			}
			setHead(newHead);
			
		}
	}

	@Override
	public void removeFirst() {
		if (!getHead().isNIL()) {
			if (getHead().equals(getLast())) {
				DoubleLinkedListNode<T> newStructure = new DoubleLinkedListNode<T>();
			
				setLast(newStructure);
				setHead(newStructure);

			} else {
				setHead(getHead().getNext());
				((DoubleLinkedListNode<T>) getHead()).setPrevious(new DoubleLinkedListNode<T>());
				((DoubleLinkedListNode<T>) getHead()).getPrevious().setNext(getHead());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!getLast().isNIL()) {
			if (getLast().equals(getHead())) {
				DoubleLinkedListNode<T> newStructure = new DoubleLinkedListNode<T>();

				setHead(newStructure);
				setLast(newStructure);

			} else {
				getLast().getPrevious().setNext(new DoubleLinkedListNode<T>());
				setLast(getLast().getPrevious());
			}			
		}

	}

	@Override
	public T search(T element) {
		T res = null;
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxLast = getLast();
		while (!auxHead.equals(auxLast) 
				&& !auxHead.getNext().equals(auxLast) 
				&& !auxHead.getData().equals(element) 
				&& !auxLast.getData().equals(element)) {

			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
		}

		if (auxHead.getData().equals(element)) {
			res = auxHead.getData();
		} else if (auxLast.getData().equals(element)) {
			res = auxLast.getData();
		}

		return res;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>();
			newLast.setData(element);
			newLast.setPrevious(getLast());
			newLast.setNext(new DoubleLinkedListNode<T>());
			
			getLast().setNext(newLast);
			
			if (getLast().isNIL()) {
				setHead(newLast);
			}
			
			setLast(newLast);
		}
	}

	@Override
	public void remove(T element) {
		if (getHead().getData().equals(element)) {
			removeFirst();
		} else if (getLast().getData().equals(element)) {
			removeLast();
		} else {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}

			if (!aux.isNIL()) {
				aux.getPrevious().setNext(aux.getNext());
				((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
			}
		}
	}


	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
