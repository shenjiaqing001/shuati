/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc540 {
    public int singleNonDuplicate(int[] nums) {

        return findSingle(nums, 0, nums.length - 1);
    }

    public int findSingle(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        if (mid % 2 == 1) {
            mid--;
        }

        if (nums[mid] == nums[mid + 1])
            return findSingle(nums, mid + 2, right);
        else {
            return findSingle(nums, left, mid);
        }
    }
}
