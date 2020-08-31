/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/17/20
 */
public class lc174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) return 0;
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = dungeon[n - 1][m - 1] >= 0 ? 1 :
                Math.abs(dungeon[n - 1][m - 1]) + 1;
        for (int i = n - 2; i >= 0; --i) {
            int tmp = dp[i + 1][m - 1] - dungeon[i][m - 1];
            dp[i][m - 1] = tmp <= 0 ? 1 : tmp;
        }
        for (int i = m - 2; i >= 0; --i) {
            int tmp = dp[n - 1][i + 1] - dungeon[n - 1][i];
            dp[n - 1][i] = (tmp <= 0) ? 1 : tmp;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = m - 2; j >= 0; --j) {
                int tmp1 = dp[i + 1][j] - dungeon[i][j];
                int tmp2 = dp[i][j + 1] - dungeon[i][j];
                dp[i][j] = Math.min(tmp1, tmp2) <= 0 ? 1 : Math.min(tmp1, tmp2);
            }
        }
        return dp[0][0];
    }
}
