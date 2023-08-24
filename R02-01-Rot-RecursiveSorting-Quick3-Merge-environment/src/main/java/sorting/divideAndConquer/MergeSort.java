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
		if (leftIndex < rightIndex && leftIndex > -1 && rightIndex < array.length) {

			int middle = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);

			merge(array, leftIndex, middle, rightIndex);

		}


	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		
		Integer[] aux = new Integer[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[i] = (int) array[i];
		}

		int i = leftIndex;
		int k = leftIndex;
		int j = middle + 1;

		while (i <= middle && j <= rightIndex) {
			if (aux[i].compareTo(aux[j]) < 0) {
				array[k] = (T) aux[i]; 
				k++; i++;
			} else {
				array[k] = (T) aux[j];
				k++; j++;
			}
		}

		while(i <= middle) {
			array[k] = (T) aux[i];
			k++; i++;
		}
		

		while(j <= rightIndex) {
			array[k] = (T) aux[j];
			k++; j++;
		}
		
	}
}
