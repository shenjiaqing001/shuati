/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/20
 */
public class lc329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = dfs(matrix, dp, i, j);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int dfs(int[][] matrix, int[][] dp, int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        int max = 1;
        for (int i = 0; i < 4; ++i) {
            int nextx = x + dirs[i][0];
            int nexty = y + dirs[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= matrix.length || nexty >= matrix[0].length ||
                    matrix[nextx][nexty] <= matrix[x][y]) {
                continue;
            }
            int length = 1 + dfs(matrix, dp, nextx, nexty);
            max = Math.max(length, max);
        }
        dp[x][y] = max;
        return max;
    }
}
