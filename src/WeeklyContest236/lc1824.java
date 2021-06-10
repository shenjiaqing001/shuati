package WeeklyContest236;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/15
 */
public class lc1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][4];
        dp[0][1] = 1;
        dp[0][3] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i][obstacles[i]] = 555_555_555;
            for (int j = 1; j <= 3; ++j) {
                if (obstacles[i] != j ) dp[i][j] = dp[i - 1][j];
            }
            if (obstacles[i] != 1) {
                dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][2], dp[i][3]) + 1);
            }
            if (obstacles[i] != 2) {
                dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][1], dp[i][3]) + 1);
            }
            if (obstacles[i] != 3) {
                dp[i][3] = Math.min(dp[i][3], Math.min(dp[i][2], dp[i][1]) + 1);
            }
        }
        for(int j = 1;j<=3;++j) {
            for (int i = 0; i <n; ++i) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return Math.min(dp[n-1][1], Math.min(dp[n-1][2], dp[n-1][3]));
    }
}
