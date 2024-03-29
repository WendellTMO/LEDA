package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 4);

	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);

		
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertFalse(lista1.isEmpty());

		((DoubleLinkedList<Integer>) lista1).removeFirst();
		
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);


		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertFalse(lista1.isEmpty());

		((DoubleLinkedList<Integer>) lista1).removeLast();

		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);

	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {  }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);

		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertFalse(lista1.isEmpty());
		
		((DoubleLinkedList<Integer>) lista1).removeLast();

		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);


		((DoubleLinkedList<Integer>) lista1).insert(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista1.toArray());
		Assert.assertFalse(lista1.isEmpty());

		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);

		((DoubleLinkedList<Integer>) lista1).insert(4);
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);

	}

	@Test
	public void testEverything() {
		((DoubleLinkedList<Integer>)lista1).remove(2);
		Assert.assertArrayEquals(new Integer[] { 3, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>)lista1).remove(1);
		Assert.assertArrayEquals(new Integer[] { 3 }, lista1.toArray());
		((DoubleLinkedList<Integer>)lista1).remove(3);
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertTrue(lista1.isEmpty());
		Assert.assertEquals(lista1.size(), 0);
		((DoubleLinkedList<Integer>) lista1).insert(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista1.toArray());
		((DoubleLinkedList<Integer>)lista1).remove(4);
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista1.toArray());


	}
}