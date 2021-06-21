package WeeklyContest246;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/20
 */
public class lc1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        int res = 0;
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[0].length; ++j) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1 && visited[i][j] == false) {
                    if (bfs(grid1, grid2, visited, i, j)) res++;
                }
            }
        }
        return res;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean bfs(int[][] grid1, int[][] grid2, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        boolean flag = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextx = now[0] + dir[i][0];
                int nexty = now[1] + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= grid2.length || nexty >= grid2[0].length)
                    continue;
                if (grid2[nextx][nexty] == 0 || visited[nextx][nexty])
                    continue;

                if (grid1[nextx][nexty] == 0) {
                    flag = false;
                }
                visited[nextx][nexty] = true;
                q.add(new int[]{nextx, nexty});
            }
        }
        return flag;
    }
}
