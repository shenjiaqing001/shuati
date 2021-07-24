/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/23
 */
public class lc487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = 0;
        int right = 0;
        int left = 0;
        while (right < n) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[left] == 0) count--;
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
