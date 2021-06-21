/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/11
 */
public class lc688 {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] map = new int[n][n];
        dfs(map, row, column, k);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                count += map[i][j];
            }
        }
        return (double) count / Math.pow(8, k);
    }

    int[][] dir = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public void dfs(int[][] map, int x, int y, int k) {
        if (k == 0) {
            if (x >= 0 && y >= 0 && x < map.length && y < map.length) {
                map[x][y]++;
            }
            return;
        }

        for (int i = 0; i < 8; ++i) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx >= 0 && nexty >= 0 && nextx < map.length && nexty < map.length)
                dfs(map, nextx, nexty, k - 1);
        }
    }


    public double knightProbability2(int n, int k, int row, int column) {
        double[][][] map = new double[n][n][k + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                map[i][j][0] = 1;
            }
        }

        for (int l = 1; l <= k; l++) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; j++) {
                    double count = 0;
                    for (int m = 0; m < 8; ++m) {
                        int x = i + dir[m][0];
                        int y = j + dir[m][1];
                        if (x >= 0 && y >= 0 && x < map.length && y < map.length) {
                            count += map[x][y][l - 1];
                        }
                    }
                    map[i][j][l] = count / 8.0;
                }
            }
        }

        return map[row][column][k];
    }

    public static void main(String[] args) {
        double i = 10;
        System.out.println(i / 8);
    }
}
