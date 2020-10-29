import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/30
 */
public class lc611 {
    public int triangleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; --i) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) left++;
                else {
                    res += right - left;
                    right--;
                }
            }
        }
        return res;
    }
}
