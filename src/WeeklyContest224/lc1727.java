package WeeklyContest224;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/17
 */
public class lc1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (matrix[j][i] == 1)
                    matrix[j][i] = matrix[j - 1][i] + 1;
            }
        }


        for (int i = 0; i < m; ++i) {
            Arrays.sort(matrix[i]);
            for (int j = n - 1; j >= 0; --j) {
                max = Math.max(max, (n - j) * matrix[i][j]);
            }
        }
        return max;
    }
}
