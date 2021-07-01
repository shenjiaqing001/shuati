/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/30
 */
public class lc1771 {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        char[] c = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length())
                        max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return max;
    }
}
