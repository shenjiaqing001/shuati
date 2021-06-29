/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/29
 */
public class lc1216 {
    public boolean isValidPalindrome(String s, int k) {


        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder(s).reverse();
        char[] cv = sb.toString().toCharArray();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];


        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (c[i] == cv[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }


        return dp[n][n] + k >= s.length();
    }
}
