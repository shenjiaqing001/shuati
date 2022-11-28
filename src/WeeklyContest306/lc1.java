package WeeklyContest306;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/22
 */
public class lc1 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                int max = 0;
                for (int row = 0; row < 3; ++row) {
                    for (int col = 0; col < 3; ++col) {
                        max = Math.max(max, grid[i + row][j + col]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}
