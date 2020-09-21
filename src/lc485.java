/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/22
 */
public class lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int left = -1;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                left = i;
            } else {
                max = Math.max(max, i - left);
            }
        }
        return max;
    }
}
