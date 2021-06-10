import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/21
 */
public class lc410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        long sum = 0;
        long max = 0;

        for (int i = 0; i < n; ++i) {
            max = (int) Math.max(nums[i], max);
            sum += nums[i];
        }
        if (m == 1) return (int) sum;
        long left = max;
        long right = sum;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    public boolean check(int[] nums, int m, long sum) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > sum) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

}
