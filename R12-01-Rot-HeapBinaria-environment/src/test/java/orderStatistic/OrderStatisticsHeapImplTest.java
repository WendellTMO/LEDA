package orderStatistic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrderStatisticsHeapImplTest {
    
    OrderStatisticsHeapImpl<Integer> impl;
    Integer[] array;

    @Before
    public void setUp() {
        impl = new OrderStatisticsHeapImpl<Integer>();
        array = new Integer[]{82, 6, 99, 12, 34, 64, 58, 1};
        

    }

    @Test
    public void testGetOrderStatistics() {
        assertEquals(null, impl.getOrderStatistics(array, 0));
        assertEquals(new Integer(1), impl.getOrderStatistics(array, 1));
        assertEquals(new Integer(6), impl.getOrderStatistics(array, 2));
        assertEquals(new Integer(12), impl.getOrderStatistics(array, 3));
        assertEquals(new Integer(34), impl.getOrderStatistics(array, 4));
        assertEquals(new Integer(58), impl.getOrderStatistics(array, 5));
        assertEquals(new Integer(64), impl.getOrderStatistics(array, 6));
        assertEquals(new Integer(82), impl.getOrderStatistics(array, 7));
        assertEquals(new Integer(99), impl.getOrderStatistics(array, 8));
        assertEquals(null, impl.getOrderStatistics(array, 9));
    }
}
