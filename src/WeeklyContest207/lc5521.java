package WeeklyContest207;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/20
 */
public class lc5521 {
    public int maxProductPath(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        long[][][] dp = new long[x][y][2];
        boolean containsZero = false;

        if (grid[0][0] > 0) {
            dp[0][0][0] = grid[0][0];
            dp[0][0][1] = 0;
        } else if (grid[0][0] < 0) {
            dp[0][0][0] = 0;
            dp[0][0][1] = grid[0][0];
        } else {
            containsZero = true;
        }

        for (int i = 1; i < x; ++i) {
            if (grid[i][0] == 0) containsZero = true;
            if (grid[i][0] > 0) {
                dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
                dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
            } else if (grid[i][0] < 0) {
                dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
                dp[i][0][0] = dp[i - 1][0][1] * grid[i][0];
            }
        }
        for (int j = 1; j < y; ++j) {
            if (grid[0][j] == 0) containsZero = true;
            if (grid[0][j] > 0) {
                dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
                dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
            } else if (grid[0][j] < 0) {
                dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
                dp[0][j][0] = dp[0][j - 1][1] * grid[0][j];
            }
        }

        for (int i = 1; i < x; ++i) {
            for (int j = 1; j < y; ++j) {
                if (grid[i][j] == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                    containsZero = true;
                    continue;
                }
                if (grid[i][j] > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] * grid[i][j]);
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][0] * grid[i][j]);

                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][1] * grid[i][j]);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][1] * grid[i][j]);
                } else {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][1] * grid[i][j]);
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][1] * grid[i][j]);

                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][0] * grid[i][j]);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][0] * grid[i][j]);
                }
            }
        }

//         for (int i = 0; i < x; ++i) {
//             for (int j = 0; j < y; ++j) {
//                 System.out.print(dp[i][j][0] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();

//         for (int i = 0; i < x; ++i) {
//             for (int j = 0; j < y; ++j) {
//                 System.out.print(dp[i][j][1] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();

        if (dp[x - 1][y - 1][0] == 0) {
            if (containsZero == true) return 0;
            else return -1;
        } else return (int) (dp[x - 1][y - 1][0] % 1000000007);
    }
}
