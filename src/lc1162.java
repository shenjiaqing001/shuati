import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/20
 */
public class lc1162 {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int lvl = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            lvl++;
            for (int tmp = 0; tmp < size; ++tmp) {
                int[] now = q.poll();
                for (int i = 0; i < 4; ++i) {
                    int nextx = now[0] + dir[i][0];
                    int nexty = now[1] + dir[i][1];
                    if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                        continue;
                    if (grid[nextx][nexty] != 0 || visited[nextx][nexty])
                        continue;

                    visited[nextx][nexty] = true;
                    q.add(new int[]{nextx, nexty});
                }
            }
        }
        if (lvl == 1) return -1;
        return lvl - 1;
    }
}
