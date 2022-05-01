package WeeklyContest276;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/15/22
 */
public class lc3 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[][] dp = new long[n][2];
        long res = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0)
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
            dp[i][1] = dp[i][0] + questions[i][0];
            int next = i + questions[i][1] + 1;
            if (next < n) {
                dp[next][0] = Math.max(dp[next][0], dp[i][1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public long mostPoints2(int[][] questions) {
        long[][] dp = new long[questions.length][2];
        long max = 0;
        for (int i = 0; i < questions.length; i++) {
            if (i > 0) dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
            dp[i][1] = dp[i][0] + questions[i][0];
            max = Math.max(max, dp[i][1]);
            if (i + questions[i][1] + 1 < questions.length) {
                dp[i + questions[i][1] + 1][0] = Math.max(dp[i + questions[i][1] + 1][0], dp[i][1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {


    }
}
