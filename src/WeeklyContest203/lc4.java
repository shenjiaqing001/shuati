package WeeklyContest203;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/23/20
 */
public class lc4 {

    int[][] dp;

    public int stoneGameV(int[] stoneValue) {
        int res = 0;
        int[] sum = new int[stoneValue.length + 1];
        dp = new int[stoneValue.length + 1][stoneValue.length + 1];
        for (int i = 1; i <= stoneValue.length; ++i) {
            sum[i] = sum[i - 1] + stoneValue[i - 1];
        }

        return dfs(sum, 1, stoneValue.length);
    }

    public int dfs(int[] sum, int begin, int end) {
        if (begin == end) return 0;
        if (dp[begin][end] != 0) return dp[begin][end];
        int max = Integer.MIN_VALUE;
        for (int i = begin + 1; i <= end; ++i) {
            int sumLeft = sum[i - 1] - sum[begin - 1];
            int sumright = sum[end] - sum[i - 1];
            if (sumLeft < sumright) {
                max = Math.max(max, sumLeft + dfs(sum, begin, i - 1));
            } else if (sumLeft > sumright) {
                max = Math.max(max, sumright + dfs(sum, i, end));
            } else {
                max = Math.max(max, Math.max(sumLeft + dfs(sum, begin, i - 1),
                        sumright + dfs(sum, i, end)));
            }
        }
        dp[begin][end] = max;
        return max;
    }
}
