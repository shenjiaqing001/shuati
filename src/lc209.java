/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/2/20
 */
public class lc209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            while (left <= right && sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
