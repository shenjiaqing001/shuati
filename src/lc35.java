/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/26
 */
public class lc35 {
    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) return nums.length;
        if (nums[0] > target) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
