package WeeklyContest215;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/15
 */
public class lc5602 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        x = sum[n] - x;
        if (x < 0) return -1;
        int min = n;
        int lo = 0;
        int hi = 0;
        boolean flag = false;
        while (hi <= n) {
            System.out.println(sum[hi] - sum[lo]);
            if (sum[hi] - sum[lo] == x) {
                min = Math.min(min, n - hi + lo);
                hi++;
                lo++;
                flag = true;
            } else if (sum[hi] - sum[lo] < x) {
                hi++;
            } else {
                lo++;
            }
        }
        if (min == n && flag == false) return -1;
        return min;
    }
}
