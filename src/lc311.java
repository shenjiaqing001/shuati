/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int nA = A.length;
        int nB = B[0].length;
        int[][] res = new int[nA][nB];


        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                for (int k = 0; k < B[0].length; ++k) {
                    res[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return res;
    }
}
