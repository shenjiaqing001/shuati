/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/22
 */
public class lc1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] pos = new int[]{0, n / 4, n / 2, (n * 3) / 4};
        for (int p : pos) {
            int num = arr[p];
            int f = firstOccurrence(arr, num);
            int l = lastOccurrence(arr, num);
            if (l - f + 1 > n / 4) {
                return num;
            }
        }
        return -1;
    }

    private int firstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target && (middle == start || nums[middle - 1] < target)) {
                return middle;
            }
            if (target > nums[middle])
                start = middle + 1;
            else
                end = middle;
        }
        return start;

    }

    private int lastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target && (middle == end || nums[middle + 1] > target)) {
                return middle;
            }
            if (nums[middle] > target)
                end = middle;
            else
                start = middle + 1;
        }
        return start;
    }
}
