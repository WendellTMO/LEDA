package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTestAVLCountAndFill {

	protected AVLCountAndFill<Integer> tree1;
	protected AVLCountAndFill<Integer> tree2;
	protected AVLCountAndFill<Integer> tree3;
	protected static int SIZE = 10;

	@Before
	public void setUp() throws Exception {
		tree1 = new AVLCountAndFillImpl<Integer>();
		tree2 = new AVLCountAndFillImpl<Integer>();
		for (int i = 0; i < SIZE; i++) {
			tree1.insert(i);
			tree2.insert(SIZE - i);
		}
		tree3 = new AVLCountAndFillImpl<Integer>();
		Integer[] data = { 8, 4, 6, 12, 10 };
		for (Integer integer : data) {
			tree3.insert(integer);
		}
	}

	@Test
	public void testLLcount() {
		assertEquals(0, tree1.LLcount());
		assertEquals(6, tree2.LLcount());
		assertEquals(0, tree3.LLcount());
	}

	@Test
	public void testRRcount() {
		assertEquals(6, tree1.RRcount());
		assertEquals(0, tree2.RRcount());
		assertEquals(0, tree3.RRcount());
	}

	@Test
	public void testLRcount() {
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree2.LRcount());
		assertEquals(1, tree3.LRcount());
	}

	@Test
	public void testRLcount() {
		assertEquals(0, tree1.RLcount());
		assertEquals(0, tree2.RLcount());
		assertEquals(1, tree3.RLcount());
	}

	@Test
	public void testFillWithoutRebalance() {
		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
		tree1.fillWithoutRebalance(keys);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());

		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys2 = { 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
		tree1.fillWithoutRebalance(keys2);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());

		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys3 = { 1 };
		tree1.fillWithoutRebalance(keys3);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());

		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys4 = { 1, 2, 3 };
		tree1.fillWithoutRebalance(keys4);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());

		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys5 = { 1, 2, 3, 4, 6, 7, 8 ,9};
		tree1.fillWithoutRebalance(keys5);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertArrayEquals(new Integer[]{1,2,3,4,6,7,8,9}, tree1.order());

		//assertEquals(0, tree1.RLcount());

		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys7 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 45, 34, -1, 0, 10};
		tree1.fillWithoutRebalance(keys7);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());

		tree1 = new AVLCountAndFillImpl<Integer>();
		Integer[] keys8 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		tree1.fillWithoutRebalance(keys8);
		assertEquals(0, tree1.LLcount());
		assertEquals(0, tree1.RRcount());
		assertEquals(0, tree1.LRcount());
		assertEquals(0, tree1.RLcount());
		assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9,10}, tree1.order());
	}
}
