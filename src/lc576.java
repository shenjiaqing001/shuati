/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/24
 */
public class lc576 {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        long[][][] map = new long[m][n][maxMove + 1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0) map[i][j][1]++;
                if (j == 0) map[i][j][1]++;
                if (i == m - 1) map[i][j][1]++;
                if (j == n - 1) map[i][j][1]++;
            }
        }

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int k = 2; k <= maxMove; ++k) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && y >= 0 && x < m && y < n) {
                            map[x][y][k] += map[i][j][k - 1];
                            map[x][y][k] %= 1_000_000_007;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= maxMove; ++i) {
            res += map[startRow][startColumn][i];
            res %= 1_000_000_007;
        }
        return res;
    }

}
