package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	// Não coloque ele resetando aqui dentro do sort, pq na minha cabeça não faz sentido
	// Eu poderia até fazer um "MergeSort" e dentro dele ele iria fazer a contagem
	// mas ai eu iria retirar o caso daqui, e ia proteger dentro de outro método
	// Ou seja, ia fazer a mesma coisa e burlar o sistema
	// ai preferir deixar assim
	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if (leftIndex < rightIndex && leftIndex > -1 && rightIndex < array.length) {
			
			int diferenca = (rightIndex - leftIndex);

			if (diferenca <= SIZE_LIMIT) {
				insertionSort(array, leftIndex, rightIndex);

			} else {

				int middle = (leftIndex + rightIndex) / 2;

				sort(array, leftIndex, middle);
				int count = INSERTIONSORT_APPLICATIONS;
				sort(array, middle + 1, rightIndex);
				INSERTIONSORT_APPLICATIONS += count;
				
				merge(array, leftIndex, middle, rightIndex);

			}

		}

	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS += 1;
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

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		MERGESORT_APPLICATIONS += 1;
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
