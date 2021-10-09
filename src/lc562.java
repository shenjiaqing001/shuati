/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc562 {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, -1}};

    public int helper(int[][] mat, boolean[][][] visited, int x, int y) {
        int max = 0;
        for (int i = 0; i < 4; ++i) {
            if (visited[x][y][i]) continue;
            int step = 1;
            while (true) {
                int nx = x + step * dirs[i][0];
                int ny = y + step * dirs[i][1];
                if (nx < 0 || ny < 0 || nx >= mat.length || ny >= mat[0].length) break;
                if (mat[nx][ny] == 0) break;
                visited[nx][ny][i] = true;
                step++;
            }
            max = Math.max(max, step);
        }
        return max;
    }

    public int longestLine(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][][] visited = new boolean[n][m][4];

        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) {
                    max = Math.max(max, helper(mat, visited, i, j));
                }
            }
        }
        return max;
    }
}
