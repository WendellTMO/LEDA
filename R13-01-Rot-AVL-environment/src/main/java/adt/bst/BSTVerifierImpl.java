package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		boolean result = false;
		if (!getBSt().isEmpty()) {
			result = recursiveVerification(getBSt().getRoot());
		}
		return result;
	}

	private boolean recursiveVerification(BSTNode<T> node) {
		boolean result = true;
		if (node != null && !node.isEmpty()) {
			if ((node.getLeft() != null && !node.getLeft().isEmpty() && node.getLeft().getData().compareTo(node.getData()) > 0) ||
				(node.getRight() != null && !node.getRight().isEmpty() && node.getRight().getData().compareTo(node.getData()) < 0) ) {
					result = false;
				}
				result = result && recursiveVerification((BSTNode<T>) node.getLeft()) && recursiveVerification((BSTNode<T>) node.getRight());
		}

		return result;
	}
	
}
