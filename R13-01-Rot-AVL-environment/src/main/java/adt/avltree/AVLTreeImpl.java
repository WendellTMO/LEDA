package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

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
		if (!node.isEmpty()) {
			result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}
		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (Math.abs(balance) > 1) {
			
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

	}

	@Override
	public void remove(T element) {

	}

	public int height(BSTNode<T> node) {
		int tempLeft = -1;
		int tempRight = -1;

		if (!node.isEmpty()) {
			tempLeft = 1 + height((BSTNode<T>) node.getLeft());
			tempRight = 1 + height((BSTNode<T>) node.getRight());
		}
		
		return Math.max(tempLeft, tempRight);
	}

}
