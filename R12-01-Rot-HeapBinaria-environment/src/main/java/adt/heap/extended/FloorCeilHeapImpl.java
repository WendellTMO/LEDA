package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++) {
			insert(array[i]);
		}
		 
		return recursiveFloor(null, numero);
	}

	private Integer recursiveFloor(Integer search, double target) {
		Integer res = search;

		if (!isEmpty()) {
			
			Integer current = extractRootElement();
			if (current <= target) {
				if (search == null || current > search) {
					search = current;
				} 
				res = recursiveFloor(search, target);
			} else {
				res = recursiveFloor(search, target);
			}
		}

		return res;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++) {
			insert(array[i]);
		}

		return recursiveCeil(null, numero);
	}

	private Integer recursiveCeil(Integer search, double target) {
		Integer res = search;

		if (!isEmpty()) {
			Integer current = extractRootElement();
			
			if (current >= target) {
				if (search == null || current < search) {
					search = current;
				} 

				res = recursiveCeil(search, target);
 			} else {
				res = recursiveCeil(search, target);
			}
		}

		return res;
	}

}
