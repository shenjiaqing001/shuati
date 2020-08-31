/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/20
 */
public class lc154 {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        if (nums[left] == nums[mid] || nums[mid] == nums[right]) {
            return Math.min(findMin(nums, left, mid),
                    findMin(nums, mid + 1, right));
        } else {
            if (nums[mid] > nums[right])
                return findMin(nums, mid + 1, right);
            else return findMin(nums, left, mid);
        }
    }
}
