/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/11
 */
public class lc832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            int lo = 0;
            int hi = A[i].length - 1;
            while (lo < hi) {
                int tmp = A[i][lo];
                A[i][lo] = 1 - A[i][hi];
                A[i][hi] = 1 - tmp;
                lo++;
                hi--;
            }
        }
        return A;
    }
}
