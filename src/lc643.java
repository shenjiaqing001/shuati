/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/23
 */
public class lc643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) max = Math.max(max, sum / k);
        }
        return max;
    }
}
