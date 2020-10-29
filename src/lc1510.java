/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/26
 */
public class lc1510 {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; ++i) {
            if (dp[i]) continue;
            for (int j = 1; i + j * j <= n; ++j) {
                dp[i + j * j] = true;
            }
        }
        return dp[n];
    }
}
