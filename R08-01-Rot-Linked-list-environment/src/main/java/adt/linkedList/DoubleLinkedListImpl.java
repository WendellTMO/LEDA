package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> auxHead = last;
			if (last.isNIL()) {

			} else {
				auxHead.setPrevious(new DoubleLinkedListNode<T>(element, last.getNext(), ()));


			}
		}

	}

	@Override
	public void removeFirst() {
		
		
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
