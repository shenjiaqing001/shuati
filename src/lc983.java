import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc983 {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] flag = new boolean[366];
        for (int i = 0; i < days.length; ++i) {
            flag[days[i]] = true;
        }
        int[] dp = new int[366];
        for (int i = 1; i < days.length; ++i) {
            if (flag[i] != true) {
                dp[i] = dp[i - 1];
                continue;
            }

            int min = dp[i - 1] + costs[0];
            min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, dp[Math.max(0, i - 30)] + costs[2]);
            dp[i] = min;
        }
        return dp[365];
    }
}
