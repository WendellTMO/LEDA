package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class BidirectionalSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > -1 && rightIndex < array.length && leftIndex < rightIndex) {

			for (int i = leftIndex; i < rightIndex; i++) {


				int min = leftIndex;
                int max = rightIndex;

                int temp_rightindex = rightIndex;

				for (int j = leftIndex + 1; j <= rightIndex; j++) {

					if (array[j].compareTo(array[min]) < 0) {
						min = j;
					}
				}

                for (int h = rightIndex - 1; h > leftIndex - 1; h--) {
                    if (array[h].compareTo(array[max]) > 0) {
                        max = h;
                    }
                }

                Util.swap(array, temp_rightindex, max);
				Util.swap(array, i, min);
                temp_rightindex--;
			}
		}
	}
}
