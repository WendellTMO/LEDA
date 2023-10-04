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

	public void removeLast() {}

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

	@Override
	public void swap(T element1, T element2) {

		if (!getHead().isNIL() && element1 != null && element2 != null) {

			SingleLinkedListNode<T> auxHead = this.getHead();

			SingleLinkedListNode<T> auxElement1 = new SingleLinkedListNode<T>();
			SingleLinkedListNode<T> auxElement2 = new SingleLinkedListNode<T>();			

			while (!auxHead.getNext().isNIL()){
				if (getHead().getData().equals(element1)) {
					auxElement1 = getHead();
				} else if (getHead().getData().equals(element2)) {
					auxElement2 = getHead();
				}

				if (element1.equals(auxHead.getNext().getData())) {
					auxElement1 = auxHead.getNext();
				} else if (element2.equals(auxHead.getNext().getData())) {
					auxElement2 = auxHead.getNext();
				}


				auxHead = auxHead.getNext();
			}

			if (!auxElement1.isNIL() && !auxElement2.isNIL()) {
				T tempData = auxElement2.getData();
				auxElement2.setData(auxElement1.getData());
				auxElement1.setData(tempData);
			} 

		}

	}

	public T elementEnd(int k) {
		T res = null;
		SingleLinkedListNode<T> aux = getHead();
		SingleLinkedListNode<T> aux2 = getHead();
		while (!aux.isNIL() && k > 0) {
			aux = aux.getNext();
			k--;
		}

		if (k == 0 ) {
			while (!aux.isNIL()) {
				aux = aux.getNext();
				aux2 = aux2.getNext();
			}
			res = aux2.getData();
		}

	

		return res;


	}

	public static void main(String[] args) {
		SingleLinkedListImpl<Integer> a = new SingleLinkedListImpl<Integer>();
		a.insert(4);
		System.out.println(a.elementEnd(2));
		
		//a.swap(new Integer(1), new Integer(3));
		// Object[] aj = a.toArray();
		// for (int x = 0; x < aj.length; x++) {
		// 	System.out.println(aj[x]);
		// }
		
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
