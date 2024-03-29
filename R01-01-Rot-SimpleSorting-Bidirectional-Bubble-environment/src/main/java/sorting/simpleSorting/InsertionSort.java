package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > -1 && rightIndex < array.length && leftIndex < rightIndex) {

			for (int i = leftIndex; i < rightIndex; i++) {
				
				boolean swaped = true;

				int j = i + 1;
				while (swaped) {
					swaped = false;
					if (j > leftIndex && j < rightIndex + 1) {
						if (array[j].compareTo(array[j - 1]) < 0) {
							Util.swap(array, j, j - 1);
							j--;
							swaped = true;
						}
					}
				}
			}
		}
	}
}
