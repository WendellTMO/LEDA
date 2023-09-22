package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;
	public Stack<Integer> stack4;
	public Stack<Integer> stack5;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

		stack4.push(1);
		stack4.push(2);
		stack4.push(3);
		stack4.push(4);
		stack4.push(5);

	}

	private void getImplementations() {
		stack1 = new StackDoubleLinkedListImpl<Integer>(4);
		stack2 = new StackDoubleLinkedListImpl<Integer>(2);
		stack3 = new StackDoubleLinkedListImpl<Integer>(5);
		stack4 = new StackDoubleLinkedListImpl<Integer>(5);
		stack5 = new StackDoubleLinkedListImpl<Integer>(1);
		
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
		assertEquals(new Integer(5), stack4.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
		assertTrue(stack5.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
		assertTrue(stack4.isFull());
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack2.push(new Integer(5)); // levanta excecao apenas se o tamanho nao
										// permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Integer a = stack4.pop();
			assertEquals(new Integer(5), a);
			Integer b = stack4.pop();
			assertEquals(new Integer(4), b);
			assertEquals(new Integer(3), stack4.pop());
			assertEquals(new Integer(2), stack4.pop());
			assertEquals(new Integer(1), stack4.pop());
			assertTrue(stack4.isEmpty());


		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
													// stack1 for vazia
		assertEquals(new Integer(1), stack5.pop());
	}
}