package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex > -1 && rightIndex < array.length) {
			Integer[] limits_check = findLimit(array, leftIndex, rightIndex);
			


			int max_negative = limits_check[0] * - 1;
			int min_negative = limits_check[1] * - 1;
			
			int count_length_negative = (max_negative - min_negative);
			Integer[] count_negative = new Integer[count_length_negative + 1];


			int min_positive = limits_check[2];
			int max_positive = limits_check[3];

			int count_length_positive = (max_positive - min_positive);
			Integer[] count_positive = new Integer[count_length_positive + 1];
		
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i].compareTo(0) < 0) {

					if(count_negative[((array[i] * -1) - min_negative)] == null) {
						count_negative[((array[i] * -1) - min_negative)] = 1;
					} else {
						count_negative[((array[i] * -1) - min_negative)] += 1;
					}

				} else {

					if (count_positive[(array[i] - min_positive)] == null) {
						count_positive[(array[i] - min_positive)] = 1;
					} else {
						count_positive[(array[i] - min_positive)] += 1;
					}
				}
			}

			int i = 0;
			int j = count_negative.length - 1;
			int temp_left = leftIndex;
			while((j > -1 || i < count_positive.length) && temp_left <= rightIndex) {
				if (j != -1) {
					if (count_negative[j] != null) {
						while (count_negative[j] > 0) {
							array[temp_left] = (j + min_negative) * -1;
							count_negative[j] -= 1;
							temp_left += 1;
						}
					}
					
					j--;

				} else if (i != count_positive.length) { 
					if (temp_left <= rightIndex) {
						if (count_positive[i] != null) {
							while (count_positive[i] > 0) {
								array[temp_left] = i + min_positive;
								count_positive[i] -= 1;
								temp_left += 1;
							}
						}
					}
					
					i++;
				}

			}

		}
		

	}

	private Integer[] findLimit(Integer[] array, int leftIndex, int rightIndex) {
		int max_of_positive_n = array[leftIndex];
		int min_of_positive_n = array[leftIndex];

		int min_of_negative_n = array[leftIndex];
		int max_of_negative_n = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(0) < 0) {
				 
				if (array[i].compareTo(max_of_negative_n) < 0) {
					max_of_negative_n = array[i];
				}

				if(array[i].compareTo(min_of_negative_n) > 0) {
					min_of_negative_n = array[i];
				}

			} else {

				if (array[i].compareTo(min_of_positive_n) < 0){
					min_of_positive_n = array[i];
				}

				if (array[i].compareTo(max_of_positive_n) > 0) {
					max_of_positive_n = array[i];
				}
			}
		}
		
		if (min_of_negative_n >= 0 && max_of_negative_n >= 0) {
			min_of_negative_n = -1;
			max_of_negative_n = -1;
		}

		if ((min_of_positive_n < 0 && max_of_positive_n < 0)) {
			max_of_positive_n = -1;
			min_of_positive_n = -1;
		}

		Integer[] retorno = new Integer[]	{max_of_negative_n, min_of_negative_n, 
										  	min_of_positive_n, max_of_positive_n};

							
		return retorno;

	}


}
