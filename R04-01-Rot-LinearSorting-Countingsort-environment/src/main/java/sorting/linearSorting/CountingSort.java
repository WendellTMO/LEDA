package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex > -1 && rightIndex < array.length) {
			Integer[] min_and_max = findLimit(array, leftIndex, rightIndex);

			int min = min_and_max[0];
			int max = min_and_max[1];

			int count_length = (max - min);
			Integer[] count = new Integer[count_length + 1];
		
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (count[(array[i] - min)] == null) {
					count[(array[i] - min)] = 1;
				} else {
					count[(array[i] - min)] += 1;
				}
			}

			int temp_left = leftIndex;
			for (int j = 0 ; j < count.length; j++) {
				if (count[j] != null) {
					while (count[j] > 0) {
						if (temp_left <= rightIndex) {
							array[temp_left] = j + min;
							count[j] -= 1;
							temp_left += 1;
						}
					}
				}
			}
		}
		
	}

	private Integer[] findLimit(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		int min = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(min) < 0){
				min = array[i];
			}

			if (array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}
		Integer[] retorno = new Integer[] {min, max};
		
		return retorno;

	}

}
