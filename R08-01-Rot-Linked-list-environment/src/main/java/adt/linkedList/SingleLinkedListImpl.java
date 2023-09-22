package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (getHead().isNIL()) {
			res = true;
		}
		return res;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = getHead();
		while(!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T res = null;
		SingleLinkedListNode<T> auxHead = getHead();
		
		while(!auxHead.isNIL() && !auxHead.getData().equals(element)) {
			auxHead = auxHead.getNext();
		}

		if (!auxHead.isNIL()) {
			res = auxHead.getData();
		}

		return res;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> auxHead = getHead();
		
			if (getHead().isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, auxHead);
				newHead.setNext(new SingleLinkedListNode<T>());
				setHead(newHead);
		
			} else {
				while(!auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (getHead().getData().equals(element)) {
				setHead(getHead().getNext());
			} else {
				SingleLinkedListNode<T> auxHead = getHead();
				while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
					auxHead = auxHead.getNext();
				}
				if (!auxHead.isNIL()) {
					auxHead.setData(auxHead.getNext().getData());
					auxHead.setNext(auxHead.getNext().getNext());
				}
			}
		}

	}

	//TODO verificar bagulho se é NIL ou 
	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> auxHead = getHead();
		int size = size();
		T[] array = (T[]) new Object[size];

		for (int i = 0; i < size(); i++) {
			array[i] = auxHead.getData();
			auxHead = auxHead.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
