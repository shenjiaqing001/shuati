/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/20
 */
public class lc1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int[] a = new int[7];
        int[] b = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < A.length; ++i) {
            a[A[i]]++;
            b[B[i]]++;
            if (A[i] == B[i]) same[A[i]]++;
        }
        for (int i = 1; i <= 6; ++i) {
            if (a[i] + b[i] - same[i] == A.length) {
                return Math.min(A.length - a[i], A.length - b[i]);
            }
        }
        return -1;
    }
}
