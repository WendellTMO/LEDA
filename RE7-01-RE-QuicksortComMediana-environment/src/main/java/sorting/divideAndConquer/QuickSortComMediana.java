package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * A mediana de uma colecao/array de valores é o valor que divide a coleção na metade.
 * A forma mais custosa de encontrar a mediana seria ordenar o array completo e
 * escolher o elemento do meio do array. Essa abordagem limita o tempo de execucao ao
 * tempo do algoritmo de ordenacao utilizado. Sabe-se que a mediana é um
 * excelente pivot para garantir um bom tempo de execução do quicksort.
 * 
 * Voce deve implementar o algoritmo do quicksort que seleciona a mediana dos
 * dados a serem ordenados como pivot. Utilize a estrategia de selection sort
 * para encontrar a mediana (sem modificar o array original). Depois use-a 
 * como o pivot do quicksort.
 * 
 * Requisitos:
 * - Voce nao pode ordenar o array e escolher o elemento da metade
 * - Voce nao pode utilizar array extra (tem que ser in-place)
 * - O uso do selection eh apenas para encontrar a mediana, mas nao deve
 *   modificar o array de forma alguma. 
 */
public class QuickSortComMediana<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	public int selectMed(int[] arr, int leftIndex, int rightIndex) {
		int min = arr[leftIndex];
		int max = arr[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++ ) {
			if (arr[i] < min) {
				min = arr[i];
			}

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int res = selectMedInside(arr, leftIndex, rightIndex, max, min);
		
		return 0;
	}

	private int selectMedInside(int[] arr, int leftIndex, int rightIndex, int max, int min) {
		return 0;
	}

	public static void main(String[] args) {
		QuickSortComMediana a = new QuickSortComMediana<>();
		
		System.out.println(a.selectMed(new int[] {1,2,3,4,5}, 0, 4));
	}

}
