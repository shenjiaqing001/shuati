import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return slidingWindow(A, K) - slidingWindow(A, K - 1);
    }

    public int slidingWindow(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < A.length) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            if (map.get(A[right]) == 1) {
                count++;
            }
            right++;

            while (count > K) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    count--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
