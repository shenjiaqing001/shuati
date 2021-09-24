package WeeklyContest258;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/11
 */
public class lc2002 {
    public static void main(String[] args) {
        lc2002 test = new lc2002();
        test.maxProduct("zqz");
    }

    public int maxProduct(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] dp = new int[1 << n];
        for (int i = 1; i < (1 << n); ++i) {
            dp[i] = palidrome(c, i);
        }
        int max = 0;
        for (int i = 1; i < (1 << n); ++i) {
            max = Math.max(max, dp[i] * dp[(1 << n) - 1 - i]);
        }
        return max;
    }

    public int palidrome(char[] c, int index) {
        int[][] dp = new int[c.length][c.length];
        boolean[] used = new boolean[c.length];
        for (int i = 0; i < c.length; ++i) {
            used[i] = ((index >> i) & 1) > 0;
        }

        int max = 1;
        for (int i = c.length - 1; i >= 0; i--) {
            if (used[i]) dp[i][i] = 1;
            for (int j = i + 1; j < c.length; j++) {
                if (used[i] && used[j] && c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
