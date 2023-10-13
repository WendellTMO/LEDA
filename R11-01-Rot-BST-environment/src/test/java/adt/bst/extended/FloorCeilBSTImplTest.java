package adt.bst.extended;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilBSTImplTest {

    FloorCeilBSTImpl impl;

    @Before
    public void setUp() {
        impl = new FloorCeilBSTImpl();
    }

    @Test
    public void testCeil() {
        Integer[] array = new Integer[] {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer[] array2 = new Integer[] {8, 10, 4, 6, 2, 0, 18, 22, -4};
        Integer[] array3 = new Integer[] {-40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232};

        assertEquals(new Integer(5), impl.ceil(array, 4));
        assertEquals(new Integer(5), impl.ceil(array, 4.5));
        assertEquals(new Integer(6), impl.ceil(array, 5.5));
        assertEquals(null, impl.ceil(array, 1000.923));
        assertEquals(new Integer(-40), impl.ceil(array, -485.65));

        for (int i = 0; i < array3.length - 1; i++) {
            assertEquals(new Integer(array3[i + 1]), impl.ceil(array, array3[i]));
        }

        for (int i = 0; i < array2.length; i++) {
            assertEquals(new Integer(array2[i]), impl.ceil(array2, array2[i] - 1));
        }
    }

    @Test
    public void testFloor() {
        Integer[] array = new Integer[] {6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40};
        Integer[] array2 = new Integer[] {8, 10, 4, 6, 2, 0, 18, 22, -4};

        assertEquals(new Integer(2), impl.floor(array, 4));
        assertEquals(new Integer(2), impl.floor(array, 4.5));
        assertEquals(new Integer(5), impl.floor(array, 5.5));
        assertEquals(null, impl.floor(array, -45));
        assertEquals(new Integer(232), impl.floor(array, 1000.923));

        for (int i = 0; i < array.length; i++) {
            assertEquals(new Integer(array[i]), impl.floor(array, array[i]));
        }

        for (int i = 0; i < array2.length; i++) {
            assertEquals(new Integer(array2[i]), impl.floor(array2, array2[i] + 1));
        }


    }
}
