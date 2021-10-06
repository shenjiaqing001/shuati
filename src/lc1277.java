/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/23
 */
public class lc1277 {
    public int countSquares(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] dp = new int[x][y];
        int res = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        if (dp[i - 1][j - 1] > 0 && dp[i - 1][j] > 0 && dp[i][j - 1] > 0) {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),
                                    dp[i][j - 1]) + 1;
                            res += dp[i][j];

                        } else {
                            dp[i][j] = 1;
                            res += 1;
                        }
                    } else {
                        dp[i][j] = 1;
                        res += 1;
                    }
                }
            }
        }
        return res;
    }


    public int countSquares2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
