import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc891 {

    // 1 2 3 4
    // 1 2,1 3,1 4,2 3,2 4,3 4     1 2 3 1 2 1
    // 1 2 3,1 2 4,2 3 4,           2 3 2
    // 1 2 3 4                      3

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long res = 0;
        long pow = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < A.length; ++i) {
            res = (res + A[i] * pow - A[A.length - i - 1] * pow) % mod;
            pow = pow * 2 % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 5));
    }
}
