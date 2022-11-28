package WeeklyContest303;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/22
 */
public class lc2 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean flag = true;
                for (int k = 0; k < n; ++k) {
                    if (grid[i][k] != grid[k][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) res++;
            }
        }
        return res;
    }
}
