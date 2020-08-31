/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < A.length) {
            if (A[right++] != 1) {
                K--;
                while (K < 0) {
                    if (A[left++] == 0) K++;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
