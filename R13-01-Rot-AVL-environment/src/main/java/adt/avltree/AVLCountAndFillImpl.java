package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		Arrays.sort(array);

		T[] arr = removeElementosRepetidos(array);

		int level = 0;
		while (filling(arr, 0, arr.length - 1, level)) {
			level++;
		}
	}

	@SuppressWarnings("unchecked")
	private T[] removeElementosRepetidos(T[] array) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < array.length; i++) {
			if (!list.contains(array[i])) {
				list.add(array[i]);
			}
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	private boolean filling(T[] array, int left, int right, int level) {
		boolean result = false;
		if (left <= right) {
			int middle = (left + right) / 2;
			if (level == 0) {
				insert(array[middle]);

				result = true;
			} else {
				result = filling(array, left, middle - 1, level - 1);
				result = filling(array, middle + 1, right, level - 1);
			}
		}
		return result;

	}

	@Override	
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
					LLcounter++;
				} else {
					// LR case
					Util.leftRotation((BSTNode<T>) node.getLeft());
					newNode = Util.rightRotation(node);
					LRcounter++;
				}

			} else {
				// RR Case
				if (rightBalance <= 0) {
					newNode = Util.leftRotation(node);
					RRcounter++;
				} else {
					// RL case
					Util.rightRotation((BSTNode<T>) node.getRight());
					newNode = Util.leftRotation(node);
					RLcounter++;
				}
			}
			if (getRoot().equals(node) && newNode != null) {
				root = newNode;
			}
		}
	}

}
