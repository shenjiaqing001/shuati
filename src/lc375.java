/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/30
 */
public class lc375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[201][201];

        dfs(dp, 1, n);
        return dfs(dp, 1, n);
    }

    public int dfs(int[][] dp, int left, int right) {
        if (left >= right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; ++i) {
            min = Math.min(min, Math.max(dfs(dp, left, i - 1), dfs(dp, i + 1, right)) + i);
        }
        System.out.println(left + " " + right + " " + dp[left][right]);
        dp[left][right] = min;
        return min;
    }

}
