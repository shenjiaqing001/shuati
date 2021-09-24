package OnlineAssessment.Google2021NG;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/23
 */
public class q1 {

    public static int solution(int[] A) {
        // abs ( a[i] - a[j] ) = abs(i - j)
        // a[i] + i = a[j] + j
        // a[i] - i = a[j] - j
        int n = A.length;
        Map<Integer, Integer> minusMap = new HashMap<>();
        Map<Integer, Integer> plusMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if (plusMap.containsKey(A[i] + i)) {
                max = Math.max(max, i - plusMap.get(A[i] + i));
            } else {
                plusMap.put(i + A[i], i);
            }
            if (minusMap.containsKey(A[i] - i)) {
                max = Math.max(max, i - minusMap.get(A[i] - i));
            } else {
                minusMap.put(A[i] - i, i);
            }
        }
        return max;
    }
}
