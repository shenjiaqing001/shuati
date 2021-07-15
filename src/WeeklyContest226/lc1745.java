package WeeklyContest226;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/31
 */
public class lc1745 {

    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] c = s.toCharArray();

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (c[i] == c[j]) {
                    if (i >= j - 1) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else dp[i][j] = false;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (dp[0][i] && dp[i + 1][j - 1] && dp[j][n - 1]) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        lc1745 test = new lc1745();
        test.checkPartitioning("acab");
    }
}
