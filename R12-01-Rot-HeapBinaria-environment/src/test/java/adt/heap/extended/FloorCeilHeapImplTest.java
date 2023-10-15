package adt.heap.extended;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import adt.heap.ComparatorMaxHeap;

public class FloorCeilHeapImplTest {
    
    FloorCeilHeapImpl impl;
    Integer[] array;

    @Before 
    public void setUp() {
        impl = new FloorCeilHeapImpl(new ComparatorMaxHeap<Integer>());
        array = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
    }

    @Test
    public void testCeil() {

    }

    @Test
    public void testFloor() {
        assertEquals(new Integer(1), impl.floor(array, 3));
    }
}
