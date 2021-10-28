/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/28
 */
public class lc1793 {
    public int maximumScore(int[] nums, int k) {
        int left = k;
        int right = k;
        int min = k;
        int n = nums.length;
        int max = nums[k];
        while (0 <= left && right < n) {
            if (nums[left] <= nums[right]) {
                min = nums[right];
            } else {
                min = nums[left];
            }
            while (left >= 0 && nums[left] >= min) left--;
            while (right < n && nums[right] >= min) right++;
            max = Math.max(max, min * (right - left - 1));
        }

        while (left >= 0) {
            min = Math.min(min, nums[left]);
            left--;
            max = Math.max(max, min * (right - left - 1));
        }

        while (right < n) {
            min = Math.min(min, nums[right]);
            right++;
            max = Math.max(max, min * (right - left - 1));
        }

        return max;
    }
}
