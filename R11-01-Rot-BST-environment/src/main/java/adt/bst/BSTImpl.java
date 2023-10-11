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
		int res = -1;
		if (!getRoot().isEmpty()) {
			res = 1 + recursiveHeight(getRoot());
		}

		return res;

	}

	private int recursiveHeight(BSTNode<T> node) {
		int res = 0;
		int tempLeft = 0;
		int tempRight = 0;
		if (node != null && !node.isEmpty()) {
			tempLeft = 1 + recursiveHeight((BSTNode<T>) node.getLeft());
		}

		if (node != null && !node.isEmpty()) {
			tempRight = 1 + recursiveHeight((BSTNode<T>) node.getRight());
		}

		if (tempLeft >= tempRight) {
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
			//node.getRight().setParent(node);
			recursiveInsert((BSTNode<T>) node.getRight(), element);
		} else {
			//node.getLeft().setParent(node);
			recursiveInsert((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return recursiveMaximum(getRoot());
	}

	private BSTNode<T> recursiveMaximum(BSTNode<T> node) {
		BSTNode<T> res = null;
		if (node.getRight().isEmpty()) {
			res = node;
		} else {
			res = (BSTNode<T>) node.getRight();
		}
		return res;
	}

	@Override
	public BSTNode<T> minimum() {
		return recursiveMinium(getRoot());
	}

	private BSTNode<T> recursiveMinium(BSTNode<T> node) {
		BSTNode<T> res = null;
		if (node.getLeft().isEmpty()) {
			res = node;
		} else {
			res = (BSTNode<T>) node.getLeft();
		}
		return res;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> res = null;
		if (element != null) {
			BSTNode<T> target = search(element);
			
			if (!target.getRight().isEmpty()) {
				res = recursiveMinium((BSTNode<T>) target.getRight());
			} else {
				BSTNode<T> y = (BSTNode<T>) target.getParent();
				
					while (y != null && !y.isEmpty() && target == y.getRight()) {
						target = y;
						y = (BSTNode<T>) y.getParent();
					}
				
				res = y;
			}

		}
		return res;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> res = null;
		if (element != null) {
			BSTNode<T> target = search(element);

			if (!target.getLeft().isEmpty()) {
				res = recursiveMaximum((BSTNode<T>) target.getLeft());
			} else {
				BSTNode<T> y = (BSTNode<T>) target.getParent();
				
					while (y != null && !y.isEmpty() && target == y.getLeft()) {
						target = y;
						y = (BSTNode<T>) y.getParent();
					}
		
				res = y;
			}
		}
		return res;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (node.equals(getRoot())) {

			} 
		}
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
