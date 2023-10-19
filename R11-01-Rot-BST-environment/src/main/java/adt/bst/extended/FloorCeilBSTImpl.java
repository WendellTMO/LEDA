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
			if (bstNode.getData() < target) {
				
				// eu atualizo o search e continuo a recursão pois não me garante que o valor que achei é aquele que queremos
				search = bstNode.getData();
				result = recursiveFloor((BSTNode<Integer>) bstNode.getRight(), search, target);
			} else if (bstNode.getData() > target) {
				result = recursiveFloor((BSTNode<Integer>) bstNode.getLeft(), search, target);
			} else {
				result = bstNode.getData();
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
			if (bstNode.getData() > target ) {
				
				// eu atualizo o search e continuo a recursão pois não me garante que o valor que achei é aquele que queremos
				search = bstNode.getData();
				result = recursiveCeil((BSTNode<Integer>) bstNode.getLeft(), search, target);
			} else if (bstNode.getData() < target ) {
				result = recursiveCeil((BSTNode<Integer>) bstNode.getRight(), search, target);
			} else {
				result = bstNode.getData();
			}
		}
		return result;
	}

}
