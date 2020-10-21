/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/22
 */
public class lc1463 {
    public int cherryPickup(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][][] dp = new int[x][y][y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                for (int k = 0; k < y; ++k) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(grid, dp, 0, 0, y - 1);
    }

    public int dfs(int[][] grid, int[][][] dp, int x, int robot1, int robot2) {
        if (x == grid.length) return 0;
        if (dp[x][robot1][robot2] != -1) return dp[x][robot1][robot2];

        int num = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                int next1 = robot1 + i;
                int next2 = robot2 + j;
                if (next1 < 0 || next2 < 0 || next1 >= grid[0].length || next2 >= grid[0].length)
                    continue;
                num = Math.max(num, dfs(grid, dp, x + 1, next1, next2));
            }
        }
        if (robot1 == robot2)
            dp[x][robot1][robot2] = num + grid[x][robot1];
        else
            dp[x][robot1][robot2] = num + grid[x][robot1] + grid[x][robot2];
        return dp[x][robot1][robot2];
    }
}
