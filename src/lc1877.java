import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length / 2; ++i) {
            min = Math.min(min, nums[i] + nums[nums.length - 1 - i]);
        }
        return min;
    }
}
