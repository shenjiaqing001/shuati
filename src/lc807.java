/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/4/22
 */
public class lc807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] vert = new int[n];
        int[] hori = new int[m];
        for (int i = 0; i < n; ++i) {
            int max = 0;
            for (int j = 0; j < m; ++j) {
                max = Math.max(max, grid[i][j]);
            }
            vert[i] = max;
        }
        for (int i = 0; i < m; ++i) {
            int max = 0;
            for (int j = 0; j < n; ++j) {
                max = Math.max(max, grid[i][j]);
            }
            hori[i] = max;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res += Math.min(vert[i], hori[j]) - grid[i][j];
            }
        }
        return res;
    }
}
