/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/29
 */
public class lc713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            product *= nums[i];
            while (product >= k && left <= i) {
                product /= nums[left];
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}
