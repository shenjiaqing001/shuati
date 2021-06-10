import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/9
 */
public class lc317 {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        int[][] reachCount = new int[n][m];
        int bCount = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1)
                    bCount++;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, i, j, distance, reachCount, bCount))
                        return -1;
                }
            }
        }



        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0 && reachCount[i][j] == bCount) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean bfs(int[][] grid, int x, int y, int[][] distance, int[][] reachCount,
                       int bCount) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int t = 0; t < size; ++t) {
                int[] now = q.poll();
                for (int i = 0; i < 4; ++i) {
                    int nextx = now[0] + dir[i][0];
                    int nexty = now[1] + dir[i][1];
                    if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                        continue;
                    if (grid[nextx][nexty] == 2 || visited[nextx][nexty])
                        continue;

                    visited[nextx][nexty] = true;
                    if (grid[nextx][nexty] == 0) {
                        distance[nextx][nexty] += step;
                        reachCount[nextx][nexty]++;
                        q.add(new int[]{nextx, nexty});
                    } else {
                        count++;
                    }
                }
            }
        }
        return count == bCount;
    }
}
