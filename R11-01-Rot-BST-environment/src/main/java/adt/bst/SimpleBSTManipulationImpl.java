package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean res = false;
		if (tree1 != null && tree2 != null) {
			res = equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return res;
	}

	private boolean equals(BSTNode<T> tree1, BSTNode<T> tree2) {
		boolean res = false;
		if (!tree1.isEmpty() && !tree2.isEmpty()) {
			res = tree1.equals(tree2) && 
					equals((BSTNode<T>) tree1.getLeft(), (BSTNode<T>) tree2.getLeft()) && 
					equals((BSTNode<T>) tree1.getRight(), (BSTNode<T>) tree2.getRight());
		} else {
			res = tree1.equals(tree2);
		}

		return res;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean res = false;
		if (tree1 != null && tree2 != null) {
			res = isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return res;
	}

	private boolean isSimilar(BSTNode<T> tree1, BSTNode<T> tree2) {
		boolean res = false;
		if (tree1.isEmpty() && tree2.isEmpty()) {
			res = true;
		} else if (!tree1.isEmpty() && !tree2.isEmpty()) {
			res = isSimilar((BSTNode<T>) tree1.getLeft(), (BSTNode<T>) tree2.getLeft()) &&
				  isSimilar((BSTNode<T>) tree1.getRight(), (BSTNode<T>) tree2.getRight());
		}
		return res;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T res = null;
		if (tree != null && !tree.isEmpty() && k > 0 && k < tree.size() + 1) {
			res = recursiveStatistic(tree, tree.minimum(), --k).getData();
		}
		return res;
	}

	private BSTNode<T> recursiveStatistic(BST<T> tree, BSTNode<T> node, int k) {
		BSTNode<T> result = (BSTNode<T>) node;

		if (k != 0) {
			result = recursiveStatistic(tree, tree.sucessor(node.getData()), --k);
		}

		return result;
	}
}
