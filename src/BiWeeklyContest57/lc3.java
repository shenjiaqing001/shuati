package BiWeeklyContest57;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc3 {
    public List<List<Long>> splitPainting(int[][] segments) {
        long[] dp = new long[10000 + 5];
        boolean[] flag = new boolean[10000 + 5];
        for (int[] segment : segments) {
            dp[segment[0]] += segment[2];
            dp[segment[1]] -= segment[2];
            flag[segment[0]] = true;
            flag[segment[1]] = true;
        }

        List<List<Long>> res = new LinkedList<>();
        int last = 0;
        long sum = 0;
        for (int i = 1; i <= 10000; ++i) {
            sum += dp[i];
            if (sum != dp[last] || flag[i]) {
                if (dp[last] == 0) last = i;
                else {
                    List<Long> tmp = new ArrayList<>();
                    tmp.add((long) last);
                    tmp.add((long) (i));
                    tmp.add(dp[last]);
                    res.add(tmp);
                    last = i;
                }
            }
            dp[i] = sum;
        }
        return res;
    }
}
