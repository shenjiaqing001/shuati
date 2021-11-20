import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/20
 */
public class lc259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public int threeSumSmaller2(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length && j < k; ++j) {
                while (j < k && nums[i] + nums[j] + nums[k] >= target) k--;
                if (k > j) res += k - j;
            }
        }
        return res;
    }
}
