/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/14/21
 */
public class lc361 {

    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, solve(grid, i, j));
                }
            }
        }
        return max;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int solve(char[][] grid, int x, int y) {
        int res = 0;
        for (int[] dir : dirs) {
            int step = 1;
            while (true) {
                int nx = x + step * dir[0];
                int ny = y + step * dir[1];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) break;
                if (grid[nx][ny] == 'W') break;
                if (grid[nx][ny] == 'E') res++;
                step++;
            }
        }
        return res;
    }

}
