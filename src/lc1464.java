import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/6
 */
public class lc1464 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        return (nums[n] - 1) * (nums[n - 1] - 1);
    }
}
