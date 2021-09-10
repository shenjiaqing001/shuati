import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/18
 */
public class lc764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (mines.length == 0) return (N + 1) / 2;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(map[i], 1);
        }
        for (int i = 0; i < mines.length; ++i) {
            map[mines[i][0]][mines[i][1]] = 0;
        }

        for (int i = 0; i < N; ++i) {
            int count = 0;
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                    map[i][j] = count;
                }
            }
            count = 0;
            for (int j = N - 1; j >= 0; --j) {
                if (map[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                    map[i][j] = Math.min(count, map[i][j]);
                }
            }
        }

        for (int j = 0; j < N; ++j) {
            int count = 0;
            for (int i = 0; i < N; ++i) {
                if (map[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                    map[i][j] = Math.min(count, map[i][j]);
                }
            }
            count = 0;
            for (int i = N - 1; i >= 0; --i) {
                if (map[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                    map[i][j] = Math.min(count, map[i][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    public int orderOfLargestPlusSign2(int n, int[][] mines) {
        int[][] map = new int[n][n];
        for (int[] mine : mines) {
            map[mine[0]][mine[1]] = 1;
        }
        int max = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[i][j] == 1) continue;
                int tmpMax = 1;
                while (true) {
                    boolean flag = false;
                    for (int[] dir : dirs) {
                        int x = i + dir[0] * tmpMax;
                        int y = j + dir[1] * tmpMax;
                        if (x < 0 || x >= n || y < 0 || y >= n) {
                            flag = true;
                            break;
                        }
                        if (map[x][y] == 1) flag = true;
                    }
                    if (flag) break;
                    tmpMax++;
                }
                max = Math.max(max, tmpMax);
            }
        }
        return max;
    }
}
