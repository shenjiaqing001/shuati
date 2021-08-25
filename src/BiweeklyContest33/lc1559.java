package BiweeklyContest33;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc1559 {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (visited[i][j]) continue;
                Set<Integer> set = new HashSet<>();
                if (dfs(grid, i, j, i, j, set))
                    return true;
                for (Integer num : set) {
                    visited[num / 1000][num % 1000] = true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int nx, int ny, int fx, int fy,
                       Set<Integer> set) {
        if (set.contains(nx * 1000 + ny)) return true;
        set.add(nx * 1000 + ny);
        for (int i = 0; i < 4; ++i) {
            int nextx = nx + dir[i][0];
            int nexty = ny + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length)
                continue;
            if (nextx == fx && nexty == fy) continue;
            if (grid[nx][ny] != grid[nextx][nexty]) continue;
            if (dfs(grid, nextx, nexty, nx, ny, set))
                return true;
        }
        return false;
    }
}
