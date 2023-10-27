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
		int skip = array.length / 2;
		int control = skip;
		int i = 0;
		List<T> visited = new ArrayList<T>();
		while (i < array.length) {
			if (control < array.length) {
				if (!visited.contains(array[control])) {
					insert(array[control]);
					visited.add(array[control]);
					i++;
				}
				
				control += skip +1;
		
			} else {
				skip = (skip / 2) ;
				control = skip;
			}
		}

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
