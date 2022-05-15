package WeeklyContest292;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/7/22
 */
public class lc4 {
    int n, m;
    Set[][] sets;

    public boolean hasValidPath(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        sets = new Set[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                sets[i][j] = new HashSet();
            }
        }
        if (grid[0][0] == ')') return false;
        return dfs(grid, 0, 0, 1);
    }

    public boolean dfs(char[][] grid, int i, int j, int count) {
        if (count < 0) return false;
        if (i == n - 1 && j == m - 1 && count == 0) return true;
        if (sets[i][j].contains(count)) return false;
        sets[i][j].add(count);
        if (i + 1 < n) {
            if (dfs(grid, i + 1, j, grid[i + 1][j] == '(' ? count + 1 : count - 1)) return true;
        }
        if (j + 1 < m) {
            if (dfs(grid, i, j + 1, grid[i][j + 1] == '(' ? count + 1 : count - 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.hasValidPath(
                new char[][]{{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}});
    }

}
