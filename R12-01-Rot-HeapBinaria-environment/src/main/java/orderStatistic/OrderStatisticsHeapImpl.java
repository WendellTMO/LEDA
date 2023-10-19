package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem. 
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 *   uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null 
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	
	@Override
	public T getOrderStatistics(T[] array, int k) {
		PriorityQueue<T> heap = new PriorityQueue<T>();
		for (int i = 0; i < array.length; i++) {
			heap.add(array[i]);
		}

		return recursiveOrderStatistics(heap, k);
	}

	private T recursiveOrderStatistics(PriorityQueue<T> heap, int k) {

		T res = null;
		
		if (k > 0 && k <= heap.size()) {
			if (k == 1) {
				res = heap.poll();
			} else {
				heap.poll();
				res = recursiveOrderStatistics(heap, --k);
			}
		}

		return res;
	}
	
}
