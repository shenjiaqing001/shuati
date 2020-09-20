/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/21
 */
public class lc980 {
    int res = 0;

    public int uniquePathsIII(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int count = 0;
        int sx = 0, sy = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 0) count++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(grid, sx, sy, count);

        return res;
    }

    public void dfs(int[][] grid, int x, int y, int num) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return;
        if (grid[x][y] == 2) {
//            System.out.println(num);
            if (num == -1) res++;
            return;
        }

        grid[x][y] = -1;
        num--;
        dfs(grid, x, y - 1, num);
        dfs(grid, x, y + 1, num);
        dfs(grid, x - 1, y, num);
        dfs(grid, x + 1, y, num);
        num++;
        grid[x][y] = 0;
    }
}
