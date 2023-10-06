package adt.hashtable.open;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.open.AbstractHashtableOpenAddress;
import adt.hashtable.open.HashtableOpenAddressQuadraticProbingImpl;
import adt.hashtable.open.HashtableElement;

public class StudentTestHashtableOpenAddressQuadraticProbing {
	protected AbstractHashtableOpenAddress<HashtableElement> table1;
	protected AbstractHashtableOpenAddress<HashtableElement> table2;
	protected AbstractHashtableOpenAddress<HashtableElement> table3;
	protected AbstractHashtableOpenAddress<HashtableElement> table4;

	protected final int PROPOSED_SIZE = 10;

	@Before
	public void setUp() throws Exception {
		table1 = new HashtableOpenAddressQuadraticProbingImpl<HashtableElement>(
				PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION, 3, 5);
		// o tamanho real utilizado vai ser PROPOSED_SIZE
		table1.insert(new HashtableElement(10)); // coloca no slot indexado com
													// 0
		table1.insert(new HashtableElement(15)); // coloca no slot indexado com
													// 5
		table1.insert(new HashtableElement(2)); // coloca no slot indexado com 2
		table1.insert(new HashtableElement(12)); // coloca no slot indexado com
													// 8, teve 2 colisoes
		table1.insert(new HashtableElement(4)); // coloca no slot indexado com 4
		table1.insert(new HashtableElement(8)); // coloca no slot indexado com
												// 6, teve 1 colisao

		table2 = new HashtableOpenAddressQuadraticProbingImpl<HashtableElement>(
				PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION, 3, 5);
		table3 = new HashtableOpenAddressQuadraticProbingImpl<HashtableElement>(PROPOSED_SIZE, HashFunctionClosedAddressMethod.DIVISION, 3, 5);

		table4 = new HashtableOpenAddressQuadraticProbingImpl<HashtableElement>(4, HashFunctionClosedAddressMethod.DIVISION, 2, 4);


	}

	@Test
	public void testInsert() {
		assertEquals(3, table1.getCOLLISIONS());
		table1.insert(new HashtableElement(11)); // nao tem colisao. coloca no
													// slot indexado com 1
		assertEquals(3, table1.getCOLLISIONS());
		assertEquals(1, table1.indexOf(new HashtableElement(11)));

		table1.insert(new HashtableElement(21)); // tem 1 colisao. coloca no
		 											// slot indexado com 9
		assertEquals(4, table1.getCOLLISIONS());
		assertEquals(9, table1.indexOf(new HashtableElement(21)));

	}

	@Test
	public void testRemove() {
		table1.remove(new HashtableElement(17)); // elemento inexistente
		assertEquals(6, table1.size());

		table1.remove(new HashtableElement(12)); // elemento existente
		assertEquals(5, table1.size());
		assertNull(table1.search(new HashtableElement(12)));
	}

	@Test
	public void testSearch() {
		assertEquals(new HashtableElement(4),
				table1.search(new HashtableElement(4))); // elemento que existe
		assertNull(table1.search(new HashtableElement(14))); // elemento que nao
																// existe

	}

	@Test
	public void testIsEmpty() {
		assertFalse(table1.isEmpty());
		table1.remove(new HashtableElement(15)); // esvazia
		table1.remove(new HashtableElement(8));
		table1.remove(new HashtableElement(12));
		table1.remove(new HashtableElement(2));
		table1.remove(new HashtableElement(10));
		table1.remove(new HashtableElement(4));
		assertTrue(table1.isEmpty());

		assertTrue(table2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(table1.isFull());
		table1.insert(new HashtableElement(1)); // enche a tabela
		table1.insert(new HashtableElement(23));
		table1.insert(new HashtableElement(37));
		table1.insert(new HashtableElement(49));
		assertTrue(table1.isFull());

		assertFalse(table2.isFull());
	}

	@Test
	public void testSize() {
		assertEquals(6, table1.size());
		table1.insert(new HashtableElement(23));
		assertEquals(7, table1.size());
	}

	@Test
	public void test01() {
		assertTrue(table3.isEmpty());
		table3.insert(new HashtableElement(1));
		table3.insert(new HashtableElement(11));
		assertEquals(2, table3.size());

		assertEquals(9, table3.indexOf(new HashtableElement(11)));

		assertEquals(1, table3.indexOf(new HashtableElement(1)));
		assertEquals(9, table3.indexOf(new HashtableElement(11)));

		table3.remove(new HashtableElement(11));
		assertEquals(1, table3.size());
		table3.insert(new HashtableElement(21));
		assertEquals(9, table3.indexOf(new HashtableElement(21)));
		assertEquals(2, table3.size());
	}

	@Test
	public void test02() {
		table4.insert(new HashtableElement(1));
		table4.insert(new HashtableElement(1));
		assertEquals(1, table4.size());
	}



}
