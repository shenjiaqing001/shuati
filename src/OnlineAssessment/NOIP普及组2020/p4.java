package OnlineAssessment.NOIP普及组2020;

import java.util.Scanner;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/12
 */
public class p4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// hang
        int m = sc.nextInt();// lie
        int[][] dp = new int[n + 1][m + 1];
        int[][] map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }
        dp[1][1] = map[1][1];
        for (int i = 2; i <= n; ++i) {
            dp[i][1] = dp[i - 1][1] + map[i][1];
        }
        for (int j = 2; j <= m; ++j) {
            dp[1][j] = dp[1][j - 1] + map[1][j];
            for (int i = 2; i <= n; ++i) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
            int tmp = dp[n][j - 1] + map[n][j];
            dp[n][j] = Math.max(dp[n][j], tmp);
            for (int i = n - 1; i >= 1; --i) {
                tmp = Math.max(tmp, dp[i][j - 1]) + map[i][j];
                dp[i][j] = Math.max(dp[i][j], tmp);
            }
        }

        System.out.println(dp[n][m]);
    }
}
