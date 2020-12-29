import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/18
 */
public class lc454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map.containsKey(-C[i] - D[j])) {
                    res += map.get(-C[i] - D[j]);
                }
            }
        }

        return res;
    }
}
