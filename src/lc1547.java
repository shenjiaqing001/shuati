import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/2
 */
public class lc1547 {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length][cuts.length];
        return dfs(dp, cuts, 0, n, 0, cuts.length - 1);
    }

    public int dfs(int[][] dp, int[] cuts, int left, int right, int lo, int hi) {
        if (lo > hi) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi];
        if (lo == hi) {
            dp[lo][hi] = right - left;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = lo; i <= hi; ++i) {
                int l = dfs(dp, cuts, left, cuts[i], lo, i - 1);
                int r = dfs(dp, cuts, cuts[i], right, i + 1, hi);
                min = Math.min(l + r + right - left, min);
            }
            dp[lo][hi] = min;
        }
        return dp[lo][hi];
    }
}
