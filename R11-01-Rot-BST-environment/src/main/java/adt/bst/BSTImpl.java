package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return recursiveHeight(getRoot());
	}

	private int recursiveHeight(BSTNode<T> node) {
		int res = -1;
		int tempLeft = -1;
		int tempRight = -1;
		if (!node.isEmpty()) {
			tempLeft = 1 + recursiveHeight((BSTNode<T>) node.getLeft());
		}

		if (!node.isEmpty()) {
			tempRight = 1 + recursiveHeight((BSTNode<T>) node.getRight());
		}

		if (tempLeft > tempRight) {
			res = tempLeft;
		} else {
			res = tempRight;
		}

		return res;
	}

	@Override
	public BSTNode<T> search(T element) {
		return recursiveSearch(getRoot(), element);
	}

	private BSTNode<T> recursiveSearch(BSTNode<T> node, T element) {
		BSTNode<T> res = new BSTNode<T>();
		if (element != null) { 
			if (node.isEmpty() || node.getData().equals(element)) {
				res = node;
			} else if (node.getData().compareTo(element) < 0) {
				res = recursiveSearch((BSTNode<T>) node.getRight(), element);
			} else {
				res = recursiveSearch((BSTNode<T>) node.getLeft(), element);
			}
		}
		return res;
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			recursiveInsert(getRoot(), element);
		}
	}

	private void recursiveInsert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);

			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);

		} else if (node.getData().compareTo(element) < 0) {
			recursiveInsert((BSTNode<T>) node.getRight(), element);
		} else {
			recursiveInsert((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return recursiveMaximum(getRoot());
	}

	private BSTNode<T> recursiveMaximum(BSTNode<T> node) {
		BSTNode<T> res = null;
		if (!node.isEmpty()) {
			if (node.getRight().isEmpty()) {
				res = node;
			} else {
				res = recursiveMaximum((BSTNode<T>) node.getRight());
			}
		}
		return res;
	}

	@Override
	public BSTNode<T> minimum() {
		return recursiveMinimum(getRoot());
	}

	private BSTNode<T> recursiveMinimum(BSTNode<T> node) {
		BSTNode<T> res = null;
		if (!node.isEmpty()) {
			if (node.getLeft().isEmpty()) {
				res = node;
			} else {
				res = recursiveMinimum((BSTNode<T>) node.getLeft());
			}
		}
		return res;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> res = null;
		if (element != null) {
			BSTNode<T> target = search(element);
			if (!target.isEmpty()) {
				if (!target.getRight().isEmpty()) {
					res = recursiveMinimum((BSTNode<T>) target.getRight());
				} else {
					res = recursiveSucessor(target, element);
				}
			}
		}
		return res;
	}

	private BSTNode<T> recursiveSucessor(BSTNode<T> node, T element) {
		BSTNode<T> res = null;
		if (!node.getLeft().isEmpty() && node.getLeft().getData().equals(element)) {
			res = node;
		} else if (node.getParent() != null) {
			res = recursiveSucessor((BSTNode<T>) node.getParent(), node.getData());
		}
		return res;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> res = null;
		if (element != null) {
			BSTNode<T> target = search(element);
			if (!target.isEmpty()) {
				if (!target.getLeft().isEmpty()) {
					res = recursiveMaximum((BSTNode<T>) target.getLeft());
				} else {
					res = recursivePredecessor(target, element);
				}
			}
		}
		return res;
	}

	private BSTNode<T> recursivePredecessor(BSTNode<T> node, T element) {
		BSTNode<T> res = null;
		if (!node.getRight().isEmpty() && node.getRight().getData().equals(element)) {
			res = node;
		} else if (node.getParent() != null) {
			res = recursivePredecessor((BSTNode<T>) node.getParent(), node.getData());
		}

		return res;

	}

	@Override
	public void remove(T element) {
		if (element != null) {	
			BSTNode<T> node = search(element);
			if (!node.isEmpty()) {
				recursiveRemove(node);
			}
		}
	}

	private void recursiveRemove(BSTNode<T> node) {
		if (node.isLeaf()) {
			if (node.getParent() == null) {
				root = new BSTNode<T>();

			} else {
				if (node.getData().compareTo(node.getParent().getData()) < 0) {
					node.getParent().setLeft(new BSTNode<T>());
						
				} else {
					node.getParent().setRight(new BSTNode<T>());

				}
			}			

		}else if (node.getRight().isEmpty()) {
			if (node.getParent() == null) {
				root = (BSTNode<T>) root.getLeft();
				root.setParent(null);

			} else {
				node.getLeft().setParent(node.getParent());
				if (node.getData().compareTo(node.getParent().getData()) < 0) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
			}
		} else if (node.getLeft().isEmpty()) { 

			if (node.getParent() == null) {
				root = (BSTNode<T>) root.getRight();
				root.setParent(null);

			} else {
				node.getRight().setParent(node.getParent());
				if (node.getData().compareTo(node.getParent().getData()) < 0) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			}
		} else {
			BSTNode<T> sucessor = sucessor(node.getData());
			node.setData(sucessor.getData());
			recursiveRemove(sucessor);
		} 
	}

	public T[] preOrder() {
    	T[] tempArray = (T[]) new Comparable[size()];
    	int[] index = { 0 }; 
    	recursivePreOrder(getRoot(), tempArray, index);

    	return tempArray;
	}

	private void recursivePreOrder(BSTNode<T> node, T[] array, int[] index) {
    	if (!node.isEmpty()) {
        	array[index[0]++] = node.getData();
        	recursivePreOrder((BSTNode<T>) node.getLeft(), array, index);
        	recursivePreOrder((BSTNode<T>) node.getRight(), array, index);
    	}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] order() {
    	T[] tempArray = (T[]) new Comparable[size()];
    	int[] index = { 0 }; 
		recursiveOrder(getRoot(), tempArray, index);

		return tempArray;
	}

	private void recursiveOrder(BSTNode<T> node, T[] array, int[] index) {
		if (!node.isEmpty()) {
			recursiveOrder((BSTNode<T>) node.getLeft(), array, index);
			array[index[0]++] = node.getData();
			recursiveOrder((BSTNode<T>) node.getRight(), array, index);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] postOrder() {
    	T[] tempArray = (T[]) new Comparable[size()];
    	int[] index = { 0 }; 
		recursivePostOrder(getRoot(), tempArray, index);

		return tempArray;
	}

	private void recursivePostOrder(BSTNode<T> node, T[] array, int[] index) {
		if (!node.isEmpty()) {
			recursivePostOrder((BSTNode<T>) node.getLeft(), array, index);
			recursivePostOrder((BSTNode<T>) node.getRight(), array, index);
			array[index[0]++] = node.getData();
		}
	} 

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
