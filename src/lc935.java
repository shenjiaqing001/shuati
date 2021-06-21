/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/12
 */
public class lc935 {
    int[][] dir = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public int knightDialer(int step) {
        long[][] map = new long[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 1, 0}};
        int n = 4;
        int m = 3;
        for (int k = 1; k < step; ++k) {
            long[][] newMap = new long[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (map[i][j] != 0) {
                        for (int l = 0; l < 8; ++l) {
                            int x = i + dir[l][0];
                            int y = j + dir[l][1];
                            if (x >= 0 && y >= 0 && x < 4 && y < 3) {
                                newMap[i][j] = (newMap[i][j] + map[x][y]) % (1000000007);
                            }
                        }
                    }
                }
            }
            map = newMap;
        }

        long res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                res = (map[i][j] + res) % (1000000007);
            }
        }
        System.out.println(res);
        return (int) res;
    }
}
