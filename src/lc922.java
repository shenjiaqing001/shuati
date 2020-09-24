/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;

        for (i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) j += 2;
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
            }
        }
        return A;
    }
}
