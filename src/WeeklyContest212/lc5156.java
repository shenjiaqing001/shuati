package WeeklyContest212;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/25
 */
public class lc5156 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] res = new int[x][y];

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (res[i][j] == 0) {
                    dfs(matrix, res, i, j);
                }
            }
        }

        return res;
    }

    public int dfs(int[][] matrix, int[][] res, int x, int y) {
        if (res[x][y] != 0) return res[x][y];
        int max = 1;

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][y] < matrix[x][y])
                max = Math.max(max, dfs(matrix, res, i, y) + 1);
            else if (matrix[i][y] == matrix[x][y]) {
                res[x][y] = max;
                max = Math.max(max, dfs(matrix, res, i, y));
            }
        }

        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[x][j] < matrix[x][y])
                max = Math.max(max, dfs(matrix, res, x, j) + 1);
            else if (matrix[x][j] == matrix[x][y]) {
                res[x][y] = max;
                max = Math.max(max, dfs(matrix, res, x, j));
            }
        }

        res[x][y] = max;
        return max;
    }
}
