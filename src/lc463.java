/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1)
                    res += helper(grid, i, j);
            }
        }
        return res;
    }

    public int helper(int[][] grid, int x, int y) {
        int ans = 4;
        if (x - 1 >= 0 && grid[x - 1][y] == 1) ans--;
        if (x + 1 < grid.length && grid[x + 1][y] == 1) ans--;
        if (y - 1 >= 0 && grid[x][y - 1] == 1) ans--;
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) ans--;
        return ans;
    }
}
