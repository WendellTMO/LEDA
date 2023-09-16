package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean res = false;
		if (head.isNIL()) {
			res = true;
		}
		return res;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = head;
		while(!auxHead.isNIL()) {
			size++;
			auxHead = auxHead.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T res = null;
		SingleLinkedListNode<T> auxHead = head;
		while(auxHead.getData() != element && !auxHead.isNIL()) {
			auxHead = auxHead.getNext();
		}

		if (auxHead.getData() == element) {
			res = auxHead.getData();
		}

		return res;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			SingleLinkedListNode<T> auxHead = head;
		
			if (head.isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, auxHead);
				newHead.setNext(head);
				head = newHead;
		
			} else {
				while(!auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (head.getData() == element) {
			head = head.getNext();
		} else {
			SingleLinkedListNode<T> auxHead = head;
			while (auxHead.getData() != element && !auxHead.isNIL()) {
				auxHead = auxHead.getNext();
			}
			if (!auxHead.isNIL()) {
				auxHead.setData(auxHead.getNext().getData());
				auxHead.setNext(auxHead.getNext().getNext());
			}
		}

	}

	//TODO verificar bagulho se é NIL ou não
	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> auxHead = head;
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
