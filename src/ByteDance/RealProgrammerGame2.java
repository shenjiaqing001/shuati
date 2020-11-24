package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/23
 */
public class RealProgrammerGame2 {
    public static double solve(int n, int m, int k) {
        double[][] dp = new double[k + 1][n + 1];
        dp[0][0] = 1.0;
        double down = 1 / (1.0 + m);
        double[] pre = new double[n + 1];
        Arrays.fill(pre, 1.0);

        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (j <= m) dp[i][j] = pre[j] * down;
                else dp[i][j] = (pre[j] - pre[j - m - 1]) * down;
            }
            pre[0] = dp[i][0];
            for (int j = 1; j <= n; ++j) {
                pre[j] = pre[j - 1] + dp[i][j];
            }
            dp[i][n] += (1 - pre[n]);
            pre[n] = 1;
        }

        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(solve(4, 2, 30));
        List<Integer> res = new ArrayList<>();
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

}
