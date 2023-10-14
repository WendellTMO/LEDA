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

		if (rootElement() <= target) {
			search = extractRootElement();
			res = recursiveFloor(search, target);
		} else if (rootElement() > target) {
			extractRootElement();
			res = recursiveFloor(search, target);
		}

		return res;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
