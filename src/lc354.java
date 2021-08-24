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


    public int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        int n = envelopes.length;
        int[] dp = new int[n];
        int index = 0;

        for (int[] envelope : envelopes) {
            if (index == 0 || dp[index - 1] < envelope[1]) {
                dp[index++] = envelope[1];
            } else {
                int lo = 0;
                int hi = index - 1;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (dp[mid] < envelope[1]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                dp[lo] = envelope[1];
            }
        }
        return index;
    }

}
