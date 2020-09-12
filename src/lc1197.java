/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/12/20
 */
public class lc1197 {
    public int minKnightMoves(int x, int y) {
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        int[][] dp = new int[305][305];
        return dfs(x, y, dp);
    }

    public int dfs(int x, int y, int[][] dp) {
        if (dp[x][y] != 0) return dp[x][y];

        if (x == 0 && y == 0) return 0;
        if (x + y == 2) return 2;
        int num = Math.min(dfs(Math.abs(x - 2), Math.abs(y - 1), dp),
                dfs(Math.abs(x - 1), Math.abs(y - 2), dp)) + 1;
        dp[x][y] = num;
        return num;
    }
}
