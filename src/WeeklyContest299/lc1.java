package WeeklyContest299;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/25/22
 */
public class lc1 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    if (grid[i][j] == 0) return false;
                } else if (i + j == n - 1) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lc1 test = new lc1();
        test.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}});

    }
}
