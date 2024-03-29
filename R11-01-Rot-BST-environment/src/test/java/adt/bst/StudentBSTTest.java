package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.bt.BTNode;

public class StudentBSTTest {

	private BSTImpl<Integer> tree;
	private BSTImpl<Integer> tree1;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
		tree1 = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		tree1.insert(new Integer(1));
		tree1.insert(new Integer(0));
		tree1.insert(new Integer(2));
		tree1.remove(tree1.getRoot().getData());
		assertEquals(2, tree1.size());
		tree1.remove(tree1.getRoot().getData());
		assertEquals(1, tree1.size());
		tree1.remove(tree1.getRoot().getData());
		tree1.insert(new Integer(3));
		assertEquals(1, tree1.size());


		while (!tree.isEmpty()) {
		 	tree.remove(tree.getRoot().getData());	
		 	assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}

	@Test
	public void testOrder() {

		fillTree();

		Integer[] preOrd = new Integer[] {6, -34, -40, 5, 2, 0, 23, 9, 12, 76, 67, 232};
		assertArrayEquals(preOrd, tree.preOrder());

		Integer[] postOrd = new Integer[] {-40, 0, 2, 5, -34, 12, 9, 67, 232, 76, 23, 6};
		assertArrayEquals(postOrd, tree.postOrder());
		
		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		Integer[] descendingOrder = { 232, 76, 67, 23, 12, 9, 6, 5, 2, 0, -34, -40 };
		assertArrayEquals(descendingOrder, tree.descendingOrder());
	}

	@Test
	public void testConstruct() {
		Integer[] array = new Integer[] {1, 2, 3};
		tree.constructMinimalHeight(array);
		assertEquals(tree.height(), 1);
		assertArrayEquals(array, tree.order());
		
		// remove all items so we'll be able to test again
		for (int i = 0; i < array.length; i++) {
			tree.remove(array[i]);
		}

		array = new Integer[] {1, 2, 3, 4, 5};
		tree.constructMinimalHeight(array);
		assertEquals(tree.height(), 2);
		assertArrayEquals(array, tree.order());

		for (int i = 0; i < array.length; i++) {
			tree.remove(array[i]);
		}

		array = new Integer[] {1, 2, 3, 4, 5, 6, 7};
		tree.constructMinimalHeight(array);
		assertEquals(tree.height(), 2);
		assertArrayEquals(array, tree.order());

		for (int i = 0; i < array.length; i++) {
			tree.remove(array[i]);
		}

		array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8};
		tree.constructMinimalHeight(array);
		assertEquals(tree.height(), 3);
		assertArrayEquals(array, tree.order());
	}

	@Test
	public void findGreater() {
		
		// -40 -34 0 2 5 6 9 12 23 67 76 232
		fillTree();

		assertEquals(new Integer(2), tree.findKGreater(new Integer(0)));
		assertEquals(new Integer(-34), tree.findKGreater(new Integer(-40)));
		assertEquals(null, tree.findKGreater(new Integer(232)));

	}
}
