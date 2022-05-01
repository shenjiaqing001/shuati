package WeeklyContest278;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/29/22
 */
public class lc2 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] dp0 = new int[n + 2];
        int[] dp1 = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            dp0[i] = dp0[i - 1];
            if (nums[i - 1] == 0) {
                dp0[i] = dp0[i - 1] + 1;
            }
        }
        for (int i = n; i >= 1; --i) {
            dp1[i] = dp1[i + 1];
            if (nums[i - 1] == 1) {
                dp1[i] = dp1[i + 1] + 1;
            }
        }
        int max = 0;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            if (dp0[i] + dp1[i + 1] > max) {
                max = dp0[i] + dp1[i + 1];
                res = new ArrayList<>();
                res.add(i);
            }
            else if (dp0[i] + dp1[i + 1] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
