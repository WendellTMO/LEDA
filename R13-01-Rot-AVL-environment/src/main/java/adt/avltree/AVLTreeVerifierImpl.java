package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		boolean result = false;
		if (!getAVLTree().isEmpty()) {
			result = recursiveVerification(getAVLTree().getRoot());
		}
		return isBST() && result;
	}

	private boolean recursiveVerification(BSTNode<T> node) {
		boolean result = true;
		if(node != null && !node.isEmpty()) {
			int balance = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
			if (Math.abs(balance) > 1) {
				result = false;
			}
			result = result && recursiveVerification((BSTNode<T>) node.getLeft()) && recursiveVerification((BSTNode<T>) node.getRight());
		}
		return result;
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
