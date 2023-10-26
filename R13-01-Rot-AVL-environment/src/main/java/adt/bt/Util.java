package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> root = node;

		BSTNode<T> pivot = (BSTNode<T>) root.getRight();
		root.setRight(pivot.getLeft());
		root.getRight().setParent(root);

		pivot.setLeft(root);
		BSTNode<T> tempParent = (BSTNode<T>) root.getParent();
		pivot.getLeft().setParent(pivot);
		pivot.setParent(tempParent);
		if (pivot.getParent() != null) {
			if (pivot.getParent().getRight().equals(node)) {
				pivot.getParent().setRight(pivot);
			} else {
				pivot.getParent().setLeft(pivot);
			}
		}

		root = pivot;
		return root;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> root = node;

		BSTNode<T> pivot = (BSTNode<T>) root.getLeft();
		root.setLeft(pivot.getRight());
		root.getLeft().setParent(root);

		pivot.setRight(root);
		BSTNode<T> tempParent = (BSTNode<T>) root.getParent();
		pivot.getRight().setParent(pivot);
		pivot.setParent(tempParent);

		if (pivot.getParent() != null) {
			if (pivot.getParent().getLeft().equals(node)) {
				pivot.getParent().setLeft(pivot);
			} else {
				pivot.getParent().setRight(pivot);
			}
		}

		root = pivot;
		return root;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
