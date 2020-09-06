import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new LinkedList<>();
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < A.length && bIndex < B.length) {
            int left = Math.max(A[aIndex][0], B[bIndex][0]);
            int right = Math.min(A[aIndex][1], B[bIndex][1]);
            if (left <= right) {
                res.add(new int[]{left, right});
            }

            if (A[aIndex][1] < B[bIndex][1]) aIndex++;
            else bIndex++;
        }


        return res.toArray(new int[0][]);
    }
}
