package SomethingInteresting;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class coloringagrid {

    public static int color(int n) {
        if (n == 1) return 24;
        int[][] dp = new int[n + 1][9];
        dp[1][1] = 18;
        dp[1][2] = 6;

        for (int i = 2; i <= n; ++i) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 1][2];
            dp[i][3] = dp[i - 1][1] * 2 + dp[i - 1][2] * 6 + dp[i - 1][3] * 2 + dp[i - 1][5] * 2;
            dp[i][4] = dp[i - 1][1] + dp[i - 1][4] * 2;
            dp[i][5] = dp[i - 1][1] * 2 + dp[i - 1][3] + dp[i - 1][5];
            dp[i][6] = dp[i - 1][1] * 9 + dp[i - 1][2] * 6 + dp[i - 1][3] * 8 + dp[i - 1][4] * 8 +
                    dp[i - 1][5] * 8 + dp[i - 1][6] * 6 + dp[i - 1][7] * 6;
            dp[i][7] = dp[i - 1][1] * 2 + dp[i - 1][2] * 3 + dp[i - 1][3] * 2 + dp[i - 1][4] * 4 +
                    dp[i - 1][5] * 2 + dp[i - 1][6] * 2 + dp[i - 1][7] * 2;
            dp[i][8] = dp[i - 1][1] * 7 + dp[i - 1][2] * 8 + dp[i - 1][3] * 11 + dp[i - 1][4] * 10 +
                    dp[i - 1][5] * 11 + dp[i - 1][6] * 16 + dp[i - 1][7] * 16 + dp[i - 1][8] * 24;
        }

        return dp[n][8];
    }

    public static void main(String[] args) {
        System.out.println(color(4));
    }
}
