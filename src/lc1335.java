/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/26
 */
public class lc1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 0; i <= d; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        int[][] max = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            int tmp = jobDifficulty[i - 1];
            for (int j = i; j <= n; ++j) {
                tmp = Math.max(tmp, jobDifficulty[j - 1]);
                max[i][j] = tmp;
            }
        }

        for (int k = 1; k <= d; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (dp[k - 1][j] == -1) continue;
                    if (dp[k][i] == -1) {
                        dp[k][i] = dp[k - 1][j] + max[j + 1][i];
                    } else {
                        dp[k][i] = Math.min(dp[k][i], dp[k - 1][j] + max[j + 1][i]);
                    }
                }
            }
        }
        return dp[d][n];
    }
}
