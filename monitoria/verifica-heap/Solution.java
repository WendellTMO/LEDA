import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nums = input.split(" ");
        int[] heap = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            heap[i] = num;
        }

        if (isMaxHeap(heap)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


        public static int left(int i) {
            return (i * 2) + 1;
        }

        public static int right(int i) {
            return (i * 2) + 2;
        }

        public static int parent(int i) {
            return (i - 1) / 2;
        }

    public static boolean isMaxHeap(int[] array) {
        for (int i = 0; i <= parent(array.length); i++) {
            int left = left(i);
            int right = right(i);
            if ((left <= array.length-1 && array[i] < array[left]) 
                || 
                (right <= array.length-1 && array[i] < array[right]) ) {
                    return false;
                }
        }
        return true;
    }

}
