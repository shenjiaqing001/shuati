import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/9/22
 */
public class lc2128 {
    public boolean removeOnes(int[][] grid) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1) {
            for (int i = 0; i < n; ++i) {
                grid[i][0] = 1 - grid[i][0];
            }
        }
        for (int i = 1; i < n; ++i) {
            if (grid[i][0] == 1) row.add(i);
        }
        for (int j = 1; j < m; ++j) {
            if (grid[0][j] == 1) col.add(j);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                int count = 0;
                if (row.contains(i)) count++;
                if (col.contains(j)) count++;
                if (grid[i][j] == 1 && count != 1) return false;
                if (grid[i][j] == 0 && count == 1) return false;
            }
        }
        return true;
    }
}
