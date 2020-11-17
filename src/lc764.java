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
}
