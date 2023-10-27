package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;
		if (node != null && !node.isEmpty()) {
			result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}
		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		if (Math.abs(balance) > 1) {
			int rightBalance = calculateBalance((BSTNode<T>) node.getRight());
			int leftBalance = calculateBalance((BSTNode<T>) node.getLeft());

			BSTNode<T> newNode = null;
			
			if (balance == 2) {
				// LL case 
				if (leftBalance >= 0) {
					newNode = Util.rightRotation(node);
					

				} else {
					// LR case
					Util.leftRotation((BSTNode<T>) node.getLeft());
					newNode = Util.rightRotation(node);
				}

			} else {
				// RR Case
				if (rightBalance <= 0) {
					newNode = Util.leftRotation(node);

				} else {
					// RL case
					Util.rightRotation((BSTNode<T>) node.getRight());
					newNode = Util.leftRotation(node);
				}
			}

			if (getRoot().equals(node) && newNode != null) {
				root = newNode;
			}
			
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}

	@Override
	public void insert(T element) {
		recursiveInsert(getRoot(), element);
	}

	private void recursiveInsert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);

			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);

			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) > 0) {
				recursiveInsert((BSTNode<T>) node.getLeft(), element);
			} else if (node.getData().compareTo(element) < 0) {
				recursiveInsert((BSTNode<T>) node.getRight(), element);
			}
			rebalance(node);
		}
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
				rebalanceUp(node);
			}

		} else if (node.getRight().isEmpty()) {
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
			rebalanceUp(node);

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
			rebalanceUp(node);

		} else {
			BSTNode<T> sucessor = sucessor(node.getData());
			node.setData(sucessor.getData());
			recursiveRemove(sucessor);
		} 
	}

	
	private int height(BSTNode<T> node) {
		int tempLeft = -1;
		int tempRight = -1;

		if (node != null && !node.isEmpty()) {
			tempLeft = 1 + height((BSTNode<T>) node.getLeft());
			tempRight = 1 + height((BSTNode<T>) node.getRight());
		}
		
		return Math.max(tempLeft, tempRight);
	}

}
