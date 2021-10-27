import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/27
 */
public class lc1478 {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);

        int n = houses.length;
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; ++i) {
            distance[i][i] = 0;
            int preSum = 0;
            int mid = i;
            for (int j = i + 1; j < n; ++j) {
                int plus = 0;
                if ((j - i) % 2 == 0) {
                    mid++;
                    plus = (houses[mid] - houses[mid - 1]) * (mid - 1 - i) -
                            (houses[mid] - houses[mid - 1]) * (j - 1 - mid);
                }
                preSum += houses[j] - houses[mid] + plus;
                distance[i][j] = preSum;
            }
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 1; i <= n; ++i) dp[1][i] = distance[0][i - 1];
        for (int kk = 2; kk <= k; ++kk) {
            for (int i = 1; i <= n; ++i) {
                for (int j = i + 1; j <= n; ++j) {
                    dp[kk][j] = Math.min(dp[kk][j], dp[kk - 1][i] + distance[i][j - 1]);
                }
            }
        }
        return dp[k][n];
    }
}
