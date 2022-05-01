/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/23/22
 */
public class lc887 {
//    public int superEggDrop(int k, int n) {
//
//        int[][] dp = new int[k + 1][n + 1];
//
//        for (int i = 1; i <= k; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (j == 1) {
//                    dp[i][j] = 1;
//                } else if (i == 1) {
//                    dp[i][j] = j;
//                } else {
//                    dp[i][j] = j;
//                    for (int jj = 1; jj <= j; ++jj) {
//                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][jj - 1], dp[i][j - jj]) + 1);
//                    }
//                }
//            }
//        }
//        return dp[k][n];
//    }


    int[][] dp = new int[100 + 1][10000 + 1];

    public int superEggDrop(int k, int n) {
        if (k == 1) return n;
        if (n == 0 || n == 1) return n;
        if (dp[k][n] != 0) return dp[k][n];

        int left = 1;
        int right = n;
        int tmp = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            int down = superEggDrop(k - 1, mid - 1);
            int upp = superEggDrop(k, n - mid);
            tmp = Math.min(tmp, 1 + Math.max(down, upp));
            if (down < upp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return dp[k][n] = tmp;
    }


}
