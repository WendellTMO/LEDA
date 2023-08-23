package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class RecursiveInsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    private int leftIndexFixo = 0;
    private boolean first;


	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > -1 && rightIndex < array.length && leftIndex < rightIndex + 1) {

            if (verifyFirst()) {
                leftIndexFixo = leftIndex;
            }

            int sorted = leftIndex;
        
            insertSort(array, leftIndex, rightIndex, sorted);

			sort(array, leftIndex + 1, rightIndex);	            

		}
	}

    private void insertSort(T[] array, int leftIndex, int rightIndex, int sorted) {
        if (sorted > leftIndexFixo && sorted < rightIndex + 1) {
            if (array[sorted].compareTo(array[sorted - 1]) < 0) {
                Util.swap(array, sorted, sorted - 1);
            }
            insertSort(array, leftIndex, rightIndex, sorted - 1);
        }

    }

    private boolean verifyFirst() {
        if (!first) {
            first = true;
            return true;
        }
        return false;
    }

}
