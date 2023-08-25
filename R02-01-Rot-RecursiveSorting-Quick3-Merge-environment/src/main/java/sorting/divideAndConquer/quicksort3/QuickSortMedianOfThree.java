package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex > -1 && rightIndex < array.length) {

			int midIndex = (leftIndex + rightIndex) / 2;
 			medianCalculator(array, leftIndex, midIndex, rightIndex);

			int pivot = partion(array, leftIndex, rightIndex - 1);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex); 
		}		

	}

		
	private int partion(T[]array, int leftIndex, int rightIndex) {

		int i = leftIndex;
		int j = rightIndex - 1;

		int pivot_posi = rightIndex;

		while (i <= j) {
			if(array[j].compareTo(array[pivot_posi]) > 0) {
				j--;

			} else {
				if (array[pivot_posi].compareTo(array[i]) < 0) {
					Util.swap(array, i, j);
					j--;
			
				} else {
					i++;
				}
			}
		}

		Util.swap(array, pivot_posi, i);
		
		return i;
	}
	
	
	private void medianCalculator(T[] array, int left, int mid, int right) {
		if (array[left].compareTo(array[mid]) > 0) {
			Util.swap(array, left, mid);
		}

		if (array[left].compareTo(array[right]) > 0) {
			Util.swap(array, left, right);
		}

		if (array[mid].compareTo(array[right]) > 0) {
			Util.swap(array, mid, right);
		}

		Util.swap(array, mid, right - 1);
	}


}
