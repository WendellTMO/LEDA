package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.stack.Stack;
import adt.stack.StackDoubleLinkedListImpl;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;
	public Queue<Integer> queue5;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

		queue4.enqueue(1);
		queue4.enqueue(2);
		queue4.enqueue(3);
		queue4.enqueue(4);
		queue4.enqueue(5);
	}

	private void getImplementations() {
		queue1 = new QueueDoubleLinkedListImpl<Integer>(4);
		queue2 = new QueueDoubleLinkedListImpl<Integer>(2);
		queue3 = new QueueDoubleLinkedListImpl<Integer>(5);
		queue4 = new QueueDoubleLinkedListImpl<Integer>(5);
		queue5 = new QueueDoubleLinkedListImpl<Integer>(1);

	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		Integer c = queue1.head();
		assertEquals(new Integer(1), c);
		assertEquals(new Integer(1), queue4.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
		assertTrue(queue2.isFull());
		assertTrue(queue4.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!

		queue4.enqueue(new Integer(6));
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}

		try {
			Integer a = queue4.dequeue();
			assertEquals(new Integer(1), a);
			Integer b = queue4.dequeue();
			assertEquals(new Integer(2), b);
			assertEquals(new Integer(3), queue4.dequeue());
			assertEquals(new Integer(4), queue4.dequeue());
			assertEquals(new Integer(5), queue4.dequeue());
			assertTrue(queue4.isEmpty());


		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}


	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
		assertEquals(new Integer(1), queue5.dequeue());
	}

}