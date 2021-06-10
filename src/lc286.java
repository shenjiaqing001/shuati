import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc286 {
    public void wallsAndGates(int[][] rooms) {
        bfs(rooms);
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (grid[nextx][nexty] != Integer.MAX_VALUE)
                    continue;

                grid[nextx][nexty] = grid[now[0]][now[1]] + 1;
                q.add(new int[]{nextx, nexty, grid[nextx][nexty]});
            }
        }
    }
}
