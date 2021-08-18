

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/16
 */
public class lc265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        int[] smallest = new int[]{-1, -1};
        for (int i = 0; i < k; ++i) {
            dp[0][i] = costs[0][i];
            if (smallest[0] == -1) smallest[0] = i;
            else if (smallest[1] == -1) {
                if (dp[0][i] <= dp[0][smallest[0]]) {
                    smallest[1] = smallest[0];
                    smallest[0] = i;
                } else {
                    smallest[1] = i;
                }
            } else {
                if (dp[0][i] <= dp[0][smallest[0]]) {
                    smallest[1] = smallest[0];
                    smallest[0] = i;
                } else if (dp[0][i] < dp[0][smallest[1]]) {
                    smallest[1] = i;
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            int[] next = new int[]{-1, -1};
            for (int j = 0; j < k; ++j) {
                if (j == smallest[0]) {
                    dp[i][j] = costs[i][j] + dp[i - 1][smallest[1]];
                } else {
                    dp[i][j] = costs[i][j] + dp[i - 1][smallest[0]];
                }

                if (next[0] == -1) next[0] = j;
                else if (next[1] == -1) {
                    if (dp[i][j] <= dp[i][next[0]]) {
                        next[1] = next[0];
                        next[0] = j;
                    } else {
                        next[1] = j;
                    }
                } else {
                    if (dp[i][j] <= dp[i][next[0]]) {
                        next[1] = next[0];
                        next[0] = j;
                    } else if (dp[i][j] < dp[i][next[1]]) {
                        next[1] = j;
                    }
                }
            }
            smallest[0] = next[0];
            smallest[1] = next[1];
        }
        return dp[n - 1][smallest[0]];
    }
}
