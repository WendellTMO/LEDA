package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub

		if (leftIndex < rightIndex && array.length > 1) {
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);

			//merge(, , );

		}
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	private T[] merge(T[] array1, T[] array2) {
		T[] result = (T[]) new Comparable[array1.length + array2.length];

		return result;


	}
}
