package adt.heap.extended;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;

public class FloorCeilHeapImplTest {
    
    FloorCeilHeapImpl implMin;
    FloorCeilHeapImpl implMax;
    Integer[] array;

    @Before 
    public void setUp() {
        implMin = new FloorCeilHeapImpl(new ComparatorMinHeap<Integer>());
        implMax = new FloorCeilHeapImpl(new ComparatorMaxHeap<Integer>());
        array = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
    }

    @Test
    public void testCeil() {
        assertEquals(new Integer(6), implMax.ceil(array, 1.5));
        assertEquals(new Integer(1), implMax.ceil(array, 1));
        assertEquals(new Integer(6), implMax.ceil(array, 3));
        assertEquals(null, implMax.ceil(array, 100));
        assertEquals(new Integer(34), implMax.ceil(array, 15.5));
        assertEquals(new Integer(58), implMax.ceil(array, 50));
        assertEquals(null, implMax.ceil(array, 99.9));

        assertEquals(new Integer(6), implMin.ceil(array, 1.5));
        assertEquals(new Integer(1), implMin.ceil(array, 1));
        assertEquals(new Integer(6), implMin.ceil(array, 3));
        assertEquals(null, implMin.ceil(array, 100));
        assertEquals(new Integer(34), implMin.ceil(array, 15.5));
        assertEquals(new Integer(58), implMin.ceil(array, 50));
        assertEquals(null, implMin.ceil(array, 99.9));
    }

    @Test
    public void testFloor() {
        assertEquals(null, implMax.floor(array, 0.4));
        assertEquals(new Integer(1), implMax.floor(array, 1.5));
        assertEquals(new Integer(1), implMax.floor(array, 1));
        assertEquals(new Integer(1), implMax.floor(array, 3));
        assertEquals(new Integer(99), implMax.floor(array, 100));
        assertEquals(new Integer(12), implMax.floor(array, 15.5));
        assertEquals(new Integer(99), implMax.floor(array, 99.9));

        assertEquals(null, implMin.floor(array, 0.4));
        assertEquals(new Integer(1), implMin.floor(array, 1.5));
        assertEquals(new Integer(1), implMin.floor(array, 1));
        assertEquals(new Integer(1), implMin.floor(array, 3));
        assertEquals(new Integer(99), implMin.floor(array, 100));
        assertEquals(new Integer(12), implMin.floor(array, 15.5));
        assertEquals(new Integer(99), implMin.floor(array, 99.9));
    }
}
