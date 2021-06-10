package WeeklyContest238;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/25
 */
public class lc1838 {
    public int maxFrequency(int[] A, long k) {
        int left = 0;
        long sum = 0;
        int max = 1;
        Arrays.sort(A);
        for (int right = 0; right < A.length; ++right) {
            k += A[right];
            while (sum + k < (long)A[right] * (right - left + 1)) {
                sum -= A[left];
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
