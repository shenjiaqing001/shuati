package WeeklyContest275;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc1 {

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                set.add(matrix[i][j]);
            }
            for (int j = 1; j <= n; ++j) {
                if (!set.contains(j)) return false;
            }
        }

        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                set.add(matrix[j][i]);
            }
            for (int j = 1; j <= n; ++j) {
                if (!set.contains(j)) return false;
            }
        }

        return true;
    }


}
