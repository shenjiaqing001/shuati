/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc1064 {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == i) return i;
        }
        return -1;
    }
}
