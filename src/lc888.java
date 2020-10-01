import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; ++i) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; ++i) {
            sumB += B[i];
        }


        //medium = 3;
        //sumA = 2;
        //sumB = 4;

        //A-B = SumA-medium
        int medium = (sumA + sumB) / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; ++i) {
            map.put(sumA-medium - A[i], 1);
        }
        for (int i = 0; i < B.length; ++i) {
            if (map.containsKey(-B[i])) {
                return new int[]{sumA-medium + B[i], B[i]};
            }
        }
        return null;
    }
}
