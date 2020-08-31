import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        grid[x][y] = '0';
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nowX = now[0] + dir[i][0];
                int nowY = now[1] + dir[i][1];
                if (nowX >= 0 && nowX < grid.length && nowY >= 0 &&
                        nowY < grid[0].length) {
                    if (grid[nowX][nowY] == '1') {
                        grid[nowX][nowY] = '0';
                        q.add(new int[]{nowX, nowY});
                    }
                }
            }
        }
    }
}
