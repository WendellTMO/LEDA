package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		BSTImpl<Integer> BST = new BSTImpl<Integer>();
		for (int i = 0; i < array.length; i++) {
			BST.insert(array[i]);
		}
		Integer result = recursiveFloor(BST.getRoot(), null, numero);
		return result;
	}

	private Integer recursiveFloor(BSTNode<Integer> bstNode, Integer search, double target) {
		Integer result = search;
		
		if (bstNode != null && !bstNode.isEmpty()) {
			if (bstNode.getData().compareTo((int) target) <= 0) {	
				search = bstNode.getData();
				result = recursiveFloor((BSTNode<Integer>) bstNode.getRight(), search, target);
			} else {
				result = recursiveFloor((BSTNode<Integer>) bstNode.getLeft(), search, target);
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		BSTImpl<Integer> BST = new BSTImpl<Integer>();
		for (int i = 0; i < array.length; i++) {
			BST.insert(array[i]);
		}
		Integer result = recursiveCeil(BST.getRoot(), null, numero);
		return result;	
	}

	private Integer recursiveCeil(BSTNode<Integer> bstNode, Integer search, double target) {
		Integer result = search;
		if (bstNode != null && !bstNode.isEmpty()) {
			if (bstNode.getData().compareTo((int) target) > 0) {
				search = bstNode.getData();
				result = recursiveCeil((BSTNode<Integer>) bstNode.getLeft(), search, target);
			} else {
				result = recursiveCeil((BSTNode<Integer>) bstNode.getRight(), search, target);
			}
		}
		return result;
	}

}
