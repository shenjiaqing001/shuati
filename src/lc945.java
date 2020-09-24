import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/24
 */
public class lc945 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int need = 0;
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            res += Math.max(need - A[i], 0);
            need = Math.max(need, A[i]) + 1;
        }
        return res;
    }
}
