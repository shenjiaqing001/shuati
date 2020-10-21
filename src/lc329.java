/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/20
 */
public class lc329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] dp = new int[x][y];
        int max = 1;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; j++) {
                int length = dfs(matrix, dp, x, y, i, j);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int dfs(int[][] matrix, int[][] dp, int x, int y, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for (int k = 0; k < 4; ++k) {
            int nextx = i + dirs[k][0];
            int nexty = j + dirs[k][1];
            if (nextx < 0 || nexty < 0 || nextx >= x || nexty >= y ||
                    matrix[nextx][nexty] <= matrix[i][j]) {
                continue;
            }
            int length = 1 + dfs(matrix, dp, x, y, nextx, nexty);
            max = Math.max(length, max);
        }
        dp[i][j] = max;
        return max;
    }
}
