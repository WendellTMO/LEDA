package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		Integer res = -1;
		
		if (array != null && array.length != 0) {
			Integer left = 0;
			Integer right = array.length - 1;
			res = floorBinarySearch(array, left, right, x);
		}

		return res;
	}

	private Integer floorBinarySearch(Integer[] array, Integer left, Integer right, Integer target) {
		Integer res = -1;

		if (left > -1 && left <= right && right < array.length) {
			Integer mid = (left + right) / 2;
			
			if (array[mid] == target ) {
				res = array[mid];
			} else if (array[mid] < target) {
				Integer temp_res = array[mid];
				res = floorBinarySearch(array, mid + 1, right, target); 
				if (res == -1) {
					res = temp_res;
				}

			} else {
				res = floorBinarySearch(array, left, mid - 1, target);
			}
		}

		return res;
	}

}
