package BiWeeklyContest56;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs2(maze, entrance[0], entrance[1]);
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int bfs2(char[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int lvl = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            lvl++;
            for (int unuse = 0; unuse < size; ++unuse) {
                int[] now = q.poll();
                for (int i = 0; i < 4; ++i) {
                    int nextx = now[0] + dir[i][0];
                    int nexty = now[1] + dir[i][1];
                    if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                        continue;
                    if (grid[nextx][nexty] == '+' || visited[nextx][nexty])
                        continue;

                    if (nextx == 0 || nexty == 0 || nextx == grid.length - 1 ||
                            nexty == grid[0].length - 1) return lvl;
                    visited[nextx][nexty] = true;
                    distance[nextx][nexty] = lvl;
                    q.add(new int[]{nextx, nexty});
                }
            }
        }
        return -1;
    }
}
