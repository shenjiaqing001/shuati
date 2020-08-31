import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] visited = new boolean[x][y];
        int max = 0;

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    max = Math.max(max, bfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int bfs(int[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (grid[nextx][nexty] == 0 || visited[nextx][nexty] == true)
                    continue;

                visited[nextx][nexty] = true;
                count++;
                q.add(new int[]{nextx, nexty});
            }
        }
        return count;
    }

}
