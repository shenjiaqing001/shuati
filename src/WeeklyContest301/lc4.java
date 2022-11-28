package WeeklyContest301;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/9/22
 */
public class lc4 {
    Map<Integer, Integer> map = new HashMap<>();

    public void dfs(int maxValue, int n, int step, int now) {
        map.put(step, map.getOrDefault(step, 0) + 1);
        if (step == n) return;
        int tmp = 2;
        while (tmp * now <= maxValue) {
            dfs(maxValue, n, step + 1, tmp * now);
            tmp++;
        }
    }

    public int idealArrays(int n, int maxValue) {
        long mod = 1_000_000_007;
        for (int i = 1; i <= maxValue; ++i) {
            dfs(maxValue, n, 1, i);
        }
        long sum = 0;
        for (int key : map.keySet()) {
            long[][] dp = new long[key + 1][n + 1];
            dp[1][1] = 1;
            for (int i = 1; i <= n; ++i) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= key; ++i) {
                for (int j = i; j <= n; ++j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    dp[i][j] %= mod;
                }
            }
            sum += dp[key][n] * map.get(key);
            sum %= mod;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.idealArrays(10000, 10000);
    }
}
