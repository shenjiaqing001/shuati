import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/8
 */
public class lc1568 {
    public int minDays(int[][] grid) {
        int island = numIslands(grid);
        System.out.println(island);
        if (island == 0 || island >= 2) return 0;
        int x = grid.length;
        int y = grid[0].length;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    island = numIslands(grid);
                    if (island == 0 || island >= 2) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int numIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] visited = new boolean[x][y];
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(int[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                    continue;
                if (grid[nextx][nexty] == 0 || visited[nextx][nexty])
                    continue;

                visited[nextx][nexty] = true;
                q.add(new int[]{nextx, nexty});
            }
        }
    }
}
