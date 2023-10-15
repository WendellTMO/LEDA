package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		buildHeap(array);
		 
		return recursiveFloor(null, numero);
	}

	private Integer recursiveFloor(Integer search, double target) {
		Integer res = search;

		if (rootElement() != null) {
			if (rootElement() <= target) {
				search = extractRootElement();
				res = recursiveFloor(search, target);
			} else {
				extractRootElement();
				res = recursiveFloor(search, target);
			}
		}

		return res;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		buildHeap(array);

		return recursiveCeil(null, numero);
	}

	private Integer recursiveCeil(Integer search, double target) {
		Integer res = search;

		if (rootElement() != null) {
			if (rootElement() >= target) {
				search = extractRootElement();
				res = recursiveCeil(search, target);
 			} else {
				extractRootElement();
				res = recursiveCeil(search, target);
			}
		}

		return res;
	}

}
