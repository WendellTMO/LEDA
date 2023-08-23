package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		
		T res = array[0];
		for (int i = 0; i < k; i++) {
			if (i == 0) {
				T temp_res = selectSearchFirst(array, 0, res);
				res = temp_res;
			} else {
				T temp_res = selectSearch(array, 0, res);
				res = temp_res;
			}
		}
		
		return res;
	}
	
	private T selectSearch(T[] array, int leftIndex, T res) {
		
		T temp_res = res;

		if (leftIndex < array.length - 1) {
			if (array[leftIndex].compareTo(array[leftIndex + 1]) < 0) {
				if (greaterThanThisIntMethod(array, array[leftIndex], res)) {
					temp_res = selectSearch(array, leftIndex + 1, array[leftIndex]);
				}
			} else {
				temp_res = selectSearch(array, leftIndex + 1, temp_res);
			}
		}

		return temp_res;
	}

	private T selectSearchFirst(T[] array, int leftIndex, T res) {
		
		T temp_res = res;

		if (leftIndex < array.length) {
			if(array[leftIndex].compareTo(res) < 0) {
				temp_res = selectSearchFirst(array, leftIndex + 1, array[leftIndex]);
			} else {
				temp_res = selectSearchFirst(array, leftIndex + 1, temp_res);
			}
		}

		return temp_res;

	}

	private boolean greaterThanThisIntMethod(T[] array, T menor, T menor_check) {
		boolean res = false;
		
		if (menor.compareTo(menor_check) > 0) {
			res = true;
		}
		return res;
	}

}
