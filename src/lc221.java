/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    if (i > 0 && j > 0) {
                        dp[i][j] =
                                Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) +
                                        1;
                        max = Math.max(dp[i][j], max);
                    } else {
                        dp[i][j] = 1;
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
        }
        return max * max;
    }
}
