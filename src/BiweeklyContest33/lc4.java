package BiweeklyContest33;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc4 {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (visited[i][j]) continue;
                Set<Pair<Integer, Integer>> set = new HashSet<>();
                if (dfs(grid, i, j, i, j, set))
                    return true;
                for (Pair<Integer, Integer> pair : set) {
                    visited[pair.getKey()][pair.getValue()] = true;
                }
            }
        }
        return false;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public boolean dfs(char[][] grid, int nx, int ny, int fx, int fy,
                       Set<Pair<Integer, Integer>> set) {
        if (set.contains(new Pair<>(nx, ny))) return true;
        set.add(new Pair<>(nx, ny));
        for (int i = 0; i < 4; ++i) {
            int nextx = nx + dir[i][0];
            int nexty = ny + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= grid.length ||
                    nexty >= grid[0].length)
                continue;
            if (nextx == fx && nexty == fy) continue;
            if (grid[nx][ny] != grid[nextx][nexty]) continue;
            if (dfs(grid, nextx, nexty, nx, ny, set))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        set.add(new Pair<>(2, 3));
        System.out.println(set.contains(new Pair<>(2, 3)));
    }
}
