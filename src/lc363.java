import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class lc363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
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

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                max = Math.max(max, check(dp, i, j, k));
            }
        }

        return max;
    }

    public int check(int[][] dp, int i, int j, int num) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = 0;
        set.add(0);
        for (int k = 1; j < dp[0].length; ++k) {
            int sum = dp[j][k] - dp[i][k];
            if (set.ceiling(sum - num) != null) {
                max = Math.max(max, sum - set.ceiling(sum - num));
            }
            set.add(sum);
        }

        return max;
    }
}
