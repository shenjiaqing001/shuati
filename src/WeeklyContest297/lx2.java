package WeeklyContest297;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/11/22
 */
public class lx2 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; ++i) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; ++k) {
                    dp[i][j] = Math.min(dp[i][j],
                            grid[i][j] + dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
