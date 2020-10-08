import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc934 {
    public int shortestBridge(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] visited = new boolean[x][y];

        firstTimeBfs:
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    bfs(grid, i, j, visited);
                    break firstTimeBfs;
                }
            }
        }

        return secondBfs(grid);
    }


    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(int[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        grid[x][y] = -1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            grid[now[0]][now[1]] = -1;
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (grid[nextx][nexty] == 0 || visited[nextx][nexty] == true)
                    continue;

                visited[nextx][nexty] = true;
                q.add(new int[]{nextx, nexty});
            }
        }
    }

    public int secondBfs(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1)
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
                if (grid[nextx][nexty] == -1) {
                    return grid[now[0]][now[1]]-1;
                }
                if (grid[nextx][nexty] != 0)
                    continue;
                grid[nextx][nexty] = grid[now[0]][now[1]] + 1;
                q.add(new int[]{nextx, nexty});
            }
        }
        return 1;
    }
}
