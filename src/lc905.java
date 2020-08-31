/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc905 {
    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int left = 0;
        int right = 0;
        while (left < length && right < length) {
            if (A[left] % 2 == 0) {
                left++;
                right++;
            } else {
                if (A[right] % 2 == 0) {
                    int tmp = A[left];
                    A[left] = A[right];
                    A[right] = tmp;
                    left++;
                    right++;
                } else {
                    right++;
                }
            }
        }
        return A;
    }
}
