import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/30
 */
public class lc1879 {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nums1[i] ^ nums2[j];
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        return dfs(matrix, dp, 0, 0);
    }


    public int dfs(int[][] matrix, int[] dp, int index, int mask) {
        if (index == matrix.length) return 0;
        if (dp[mask] == Integer.MAX_VALUE) {
            for (int i = 0; i < matrix.length; ++i) {
                if ((mask & (1 << i)) == 0) {
                    dp[mask] = Math.min(dp[mask],
                            matrix[index][i] + dfs(matrix, dp, index + 1, mask + (1 << i)));
                }
            }
        }
        return dp[mask];
    }

}
