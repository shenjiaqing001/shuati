/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/19/22
 */
public class lc664 {
    public int strangePrinter(String s) {
        StringBuilder sb = new StringBuilder();
        char last = ' ';
        for (char c : s.toCharArray()) {
            if (c != last) {
                sb.append(c);
                last = c;
            }
        }
        s = sb.toString();
        int n = s.length();
        char[] c = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        dfs(c, 0, n - 1, dp);
        return dp[0][n - 1];
    }

    public int dfs(char[] c, int left, int right, int[][] dp) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        int min = dfs(c, left + 1, right, dp) + 1;
        for (int i = left + 1; i <= right; ++i) {
            if (c[i] == c[left]) {
                min = Math.min(min, dfs(c, left, i - 1, dp) + dfs(c, i + 1, right, dp));
            }
        }
        dp[left][right] = min;
        return dp[left][right];
    }

    public static void main(String[] args) {
        lc664 test = new lc664();
        test.strangePrinter("aba");
    }
}
