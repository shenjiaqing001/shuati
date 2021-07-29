import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/28
 */
public class lc16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 100000;
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
                if (sum <= target) left++;
                else right--;
            }
        }
        return closest;
    }
}
