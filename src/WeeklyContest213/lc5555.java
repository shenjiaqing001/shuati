package WeeklyContest213;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/1
 */
public class lc5555 {
    public int countVowelStrings(int n) {
        int[] dp = new int[6];
        if (n == 1) return 5;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for (int i = 2; i <= n; ++i) {
            int[] next = new int[6];
            for (int j = 1; j <= 5; ++j) {
                next[j] = next[j - 1] + dp[j];
            }
            dp = next;
        }
        return dp[1] + dp[2] + dp[3] + dp[4] + dp[5];
    }
}
