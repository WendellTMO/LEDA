package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > -1 && rightIndex < array.length && leftIndex <= rightIndex) {

			int min = selecSort(array, leftIndex + 1, rightIndex, leftIndex);		

			Util.swap(array, leftIndex, min);
			sort(array, leftIndex + 1, rightIndex);
		}

	}

	private int selecSort(T[] array, int leftIndex, int rightIndex, int temp_min) {

		int min = temp_min;

 		if (leftIndex <= rightIndex) {
			if (array[leftIndex].compareTo(array[min]) < 0) {
				min = leftIndex;
				return selecSort(array, leftIndex + 1, rightIndex, min);
			}
			return selecSort(array, leftIndex + 1, rightIndex, min);
		} else {
			return min;
		}
	}


}
