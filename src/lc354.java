import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[envelopes.length];
        int max = 0;
        for (int i = 0; i < envelopes.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
