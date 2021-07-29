package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class matrixPresum {

    public void presum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i + 1][j + 1] = dp[i + 1][j] + matrix[i][j];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = m - 1; j >= 0; --j) {
                dp[i + 1][j + 1] += dp[i][j + 1];
            }
        }
//            for (int i = 0; i <= n; ++i) {
//                for (int j = 0; j <= m; ++j) {
//                    System.out.print(dp[i][j]);
//                }
//                System.out.println();
//            }

    }

}
