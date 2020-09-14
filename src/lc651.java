import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/15/20
 */
public class lc651 {
    public int maxA(int n) {

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
            for (int j = 1; j <= i - 1; ++j) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[n];
    }
}
