import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[headID] = informTime[headID];
        int max = 0;

        for (int i = 0; i < n; ++i) {
            if (dp[i] == -1) {
                max = Math.max(max, dfs(dp, i, manager, informTime));
            }
        }
        return max;
    }

    public int dfs(int[] dp, int root, int[] manager, int[] informTime) {
        if (dp[root] != -1) return dp[root];
        return dp[root] = dfs(dp, manager[root], manager, informTime) + informTime[root];
    }


}
