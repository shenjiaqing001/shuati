import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/16
 */
public class lc1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + matrix[i][j];
            }
        }


        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                int subsum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int k = 1; k <= m; ++k) {
                    subsum += sum[i][k] - sum[j][k];
                    if (map.containsKey(subsum - target)) {
                        res += map.get(subsum - target);
                    }
                    map.put(subsum, map.getOrDefault(subsum, 0) + 1);
                }
            }
        }
        return res;
    }
}
