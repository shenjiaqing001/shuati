import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/9
 */
public class lc1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int max = -1;
        while (left < right) {
            if (A[left] + A[right] >= K) {
                right--;
            } else {
                max = Math.max(max, A[left] + A[right]);
                left++;
            }
        }
        return max;
    }
}
