/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc115 {
    public static void main(String[] args) {
        lc115 t = new lc115();
        System.out.println(t.numDistinct("babgbag", "bag"));
    }

    /**
     * babgbag bag
     * 1 1 2 2 3 3 3
     * 0 1 1 1 1 4 4
     * 0 0 0 1 1 1 5
     */

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; ++i)
            dp[0][i] = 1;
        for (int i = 1; i <= t.length(); ++i) {
            for (int j = 1; j <= s.length(); ++j) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
