package WeeklyContest255;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1981 {
    int min = Integer.MAX_VALUE;

    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        boolean[][] dp = new boolean[n][5000];
        dfs(mat, dp, 0, 0, target);
        return min;
    }

    void dfs(int[][] mat, boolean[][] dp, int row, int sum, int target) {
        if (row == mat.length) {
            min = Math.min(min, Math.abs(sum - target));
            return;
        }
        if (dp[row][sum]) return;
        for (int i = 0; i < mat[0].length; ++i) {
            dfs(mat, dp, row + 1, sum + mat[row][i], target);
        }
        dp[row][sum] = true;
    }


}
