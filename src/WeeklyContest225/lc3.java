package WeeklyContest225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/24
 */
public class lc3 {
    public int kthLargestValue(int[][] matrix, int k) {
        List<Integer> xor = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][j - 1];
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                matrix[i][j] = matrix[i - 1][j] ^ matrix[i][j];
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                xor.add(matrix[i][j]);
            }
        }

        for (Integer i : xor) {
            System.out.println(i);
        }

        xor.sort((o1, o2) -> o2 - o1);
        return xor.get(k - 1);
    }


}
