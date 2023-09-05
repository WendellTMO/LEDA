package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@SuppressWarnings("unchecked")
	@Override
	public T[] getKLargest(T[] array, int k) {
		T[] res = (T[]) new Comparable[] {};
		
		if (k <= array.length && k > 0) {
			res = (T[]) new Comparable[k];

			int i = 0;
			int k_largest = array.length - k;
			while (i < res.length) {
				k_largest++;				
				res[i] = orderStatistics(array, k_largest);
				i++;
			}
		}

		return res;
		//este metodo deve obrigatoriamente usar o orderStatistics abaixo.
	}
	
	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		T res = null;
		if (array != null && k > 0 && k < array.length + 1) {
			int leftIndex = 0;
			int rightIndex = array.length - 1;
			res = array[ quickSelect(array, leftIndex, rightIndex, k - 1)];
		}

		return res;
	}

	private int quickSelect(T[] array, int leftIndex, int rightIndex, int k) {
		int res = 0;
		if (leftIndex <= rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);

			if (pivot == k) {
				res = pivot;
			} else if (pivot > k) {
				res = quickSelect(array, leftIndex, pivot - 1, k);
			} else {
				res = quickSelect(array, pivot + 1, rightIndex, k);
			}
		}
		return res;
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		int i = leftIndex;
		int j = leftIndex + 1;

		int pivot_posi = leftIndex;

		while (j <= rightIndex) {
			if (array[pivot_posi].compareTo(array[j]) > 0) {
				i++;
				Util.swap(array, i, j);
			}
			j++;
		}
		Util.swap(array, pivot_posi, i);

		return i;
	}

}
