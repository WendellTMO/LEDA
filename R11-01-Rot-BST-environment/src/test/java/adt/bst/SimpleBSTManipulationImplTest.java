package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationImplTest {
    
    private SimpleBSTManipulationImpl<Integer> impl;

    @Before
    public void setUp() {
        impl = new SimpleBSTManipulationImpl<>();
    }
    
    private BSTImpl<Integer> fillTree(Integer[] array) {
        BSTImpl<Integer> tree = new BSTImpl<>();
        for (int i : array) {
            tree.insert(i);
        }
        return tree;
    }

    @Test
    public void testEquals01() {
        BSTImpl<Integer> tree1 = null;
        BSTImpl<Integer> tree2 = null;
        assertFalse(impl.equals(tree1, tree2));
    }

    @Test
    public void testEquals02() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertTrue(impl.equals(tree1, tree2));
    }

    @Test
    public void testEquals03() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 6, 23, -34 });
        assertTrue(impl.equals(tree1, tree2));
    }

    @Test
    public void testEquals04() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 6 });
        assertTrue(impl.equals(tree1, tree2));
    }

    @Test
    public void testEquals05() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 3, 0, 76, 12, 67, 232, -40});
        assertFalse(impl.equals(tree1, tree2));
    }

    @Test
    public void testEquals06() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232});
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40});
        assertFalse(impl.equals(tree1, tree2));
    }

    @Test
    public void testSimilar01() {
        BSTImpl<Integer> tree1 = null;
        BSTImpl<Integer> tree2 = null;
        assertFalse(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar02() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertTrue(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar03() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 5, 24, -35, 4, 8, 1, -1, 75, 11, 66, 231, -39 });
        assertTrue(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar04() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 5, 24, -35, 4, 8, 1, -1, 75, 11, 66, 231, -39 });
        assertFalse(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar05() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 5 });
        assertTrue(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar06() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 2, 9 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 5, 1, 8 });
        assertTrue(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testSimilar07() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 7, 9 });
        BSTImpl<Integer> tree2 = fillTree(new Integer[]{ 5, 1, 8 });
        assertFalse(impl.isSimilar(tree1, tree2));
    }

    @Test
    public void testOrderStatistic01() {
        BSTImpl<Integer> tree1 = fillTree(new Integer[]{ 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 });
        assertEquals(new Integer(-40), impl.orderStatistic(tree1, 1));
        assertEquals(new Integer(-34), impl.orderStatistic(tree1, 2));
        assertEquals(new Integer(0), impl.orderStatistic(tree1, 3));
        assertEquals(new Integer(2), impl.orderStatistic(tree1, 4));
        assertEquals(new Integer(5), impl.orderStatistic(tree1, 5));
        assertEquals(new Integer(6), impl.orderStatistic(tree1, 6));
        assertEquals(new Integer(9), impl.orderStatistic(tree1, 7));
        assertEquals(new Integer(12), impl.orderStatistic(tree1, 8));
        assertEquals(new Integer(23), impl.orderStatistic(tree1, 9));
        assertEquals(new Integer(67), impl.orderStatistic(tree1, 10));
        assertEquals(new Integer(76), impl.orderStatistic(tree1, 11));
        assertEquals(new Integer(232), impl.orderStatistic(tree1, 12));

    }

    
}