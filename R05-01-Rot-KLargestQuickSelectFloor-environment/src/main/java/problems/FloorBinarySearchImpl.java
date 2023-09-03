package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		int res = -1;
		
		if (array != null && array.length != 0) {
			int left = 0;
			int right = array.length - 1;
			res = floorBinarySearch(array, left, right, x);
		}

		return res;
	}

	private int floorBinarySearch(Integer[] array, int left, int right, int target) {
		int res = -1;

		if (left > -1 && left <= right && right < array.length) {
			int mid = (left + right) / 2;
			
			if (array[mid] == target ) {
				res = array[mid];
			} else if (array[mid] < target) {
				int temp_res = array[mid];
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
