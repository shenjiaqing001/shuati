/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/15/21
 */
public class lc867 {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
