package OnlineAssessment.CodeSignal;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class q3 {

    public int[][] solve(int[][] bubbles) {
        int n = bubbles.length;
        int m = bubbles[0].length;
        boolean[][] canExplored = new boolean[n][m];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int count = 0;
                for (int[] dir : dirs) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (bubbles[nx][ny] == bubbles[i][j]) count++;
                }

                if (count >= 2) {
                    canExplored[i][j] = true;
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (bubbles[nx][ny] == bubbles[i][j]) canExplored[nx][ny] = true;
                    }
                }
            }
        }

        int[][] res = new int[n][m];
        for (int j = 0; j < m; ++j) {
            int index = n - 1;
            for (int i = n - 1; i >= 0; --i) {
                if (!canExplored[i][j]) {
                    res[index--][j] = bubbles[i][j];
                }
            }
        }
        return res;
    }

}
