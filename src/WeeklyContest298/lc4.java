package WeeklyContest298;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/18/22
 */
public class lc4 {
    Long[][] dp;
    long[][] already;
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

    public long dfs(int m, int n, int[][] prices) {
        if (dp[m][n] != null) return dp[m][n];
        long max = 0;
        if (already[m][n] != 0) {
            max = already[m][n];
        }
        for (int i = 1; i <= n / 2; ++i) {
            max = Math.max(max, dfs(m, i, prices) + dfs(m, n - i, prices));
        }

        for (int i = 1; i <= m / 2; ++i) {
            max = Math.max(max, dfs(i, n, prices) + dfs(m - i, n, prices));
        }
        dp[m][n] = max;
        return max;
    }

    public long sellingWood(int m, int n, int[][] prices) {
        dp = new Long[m + 1][n + 1];
        already = new long[m + 1][n + 1];
        for (int[] price : prices) {
            already[price[0]][price[1]] = Math.max(already[price[0]][price[1]], (long) price[2]);
        }
        Arrays.sort(prices, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        return dfs(m, n, prices);
    }
}
