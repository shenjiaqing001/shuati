/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/16
 */
public class lc845 {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int max = 0;
        int start = 0;
        int condition = 0;
        for (int i = 1; i < A.length; ++i) {
            if (condition == 0) {
                if (A[i] > A[i - 1]) {
                    condition = 1;
                    start = i - 1;
                }
            } else if (condition == 1) {
                if (A[i] == A[i - 1]) {
                    condition = 0;
                } else if (A[i] < A[i - 1]) {
                    condition = 2;
                }
            } else {
                if (A[i] == A[i - 1]) {
                    condition = 0;
                    max = Math.max(max, i - 1 - start + 1);
                } else if (A[i] > A[i - 1]) {
                    max = Math.max(max, i - 1 - start + 1);
                    condition = 1;
                    start = i - 1;
                }
            }
        }
        if (condition == 2) {
            max = Math.max(max, A.length - 1 - start + 1);
        }
        return max;
    }
}
