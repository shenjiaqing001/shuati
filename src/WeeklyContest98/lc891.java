package WeeklyContest98;

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

    Map<Integer, Long> map = new HashMap<>();

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long res = 0;
        quickPow2();
        for (int i = 0; i < A.length - 1; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                res = ((res + (A[j] - A[i]) * map.get(j - i - 1)) % 1000000007);
            }
        }
        return (int) res;
    }

    public void quickPow2() {
        long res = 1;
        for (int i = 0; i <= 20000; ++i) {
            map.put(i, res);
            res = res * 2 % 1000000007;
        }
    }

    public static void main(String[] args) {
        lc891 t = new lc891();
    }


}
