import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;
        int res = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (grid[i][j] == 1) {
                    StringBuffer sb = new StringBuffer();
                    dfs(grid, i, j, sb, "o");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }


    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int[][] grid, int x, int y, StringBuffer sb, String dir) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;
        if (grid[x][y] == 0)
            return;
        sb.append(dir);
        grid[x][y] = 0;
        dfs(grid, x + 1, y, sb, "u");
        dfs(grid, x - 1, y, sb, "d");
        dfs(grid, x, y + 1, sb, "r");
        dfs(grid, x, y - 1, sb, "l");
        sb.append("b");
    }
}
