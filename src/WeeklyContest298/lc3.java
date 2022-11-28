package WeeklyContest298;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/18/22
 */
public class lc3 {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] dp = new int[n];
        int tmp = 0;
        for (int i = 0; i < n; ++i) {
            if (c[i] == '0') {
                tmp++;
            } else {
                dp[i] = tmp;
            }
        }
        long ans = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[i] == '1') {
                long plus = (1L << (tmp - dp[i] + count));
                if (ans + plus <= k) {
                    ans += plus;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count + tmp;
    }
}
