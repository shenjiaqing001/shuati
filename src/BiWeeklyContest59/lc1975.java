package BiWeeklyContest59;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1975 {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long res = 0;
        int count = 0;
        long min = 100000;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res += Math.abs(matrix[i][j]);
                if (matrix[i][j] <= 0) {
                    count++;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        if (count % 2 == 1) {
            res -= 2L * min;
        }
        return res;
    }
}
