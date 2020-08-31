/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/14/20
 */
public class lc162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return nums[0];
        return findPeakRecursion(nums, 0, nums.length - 1);
    }

    public int findPeakRecursion(int[] nums, int left, int right) {
        if (left == right) return left;
        int mid = (left + right) / 2;

        if (nums[mid] < nums[mid + 1])
            return findPeakRecursion(nums, mid + 1, right);
        else return findPeakRecursion(nums, left, mid);
    }
}
