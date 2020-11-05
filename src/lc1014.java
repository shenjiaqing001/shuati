/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/5
 */
public class lc1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        int top = 0;
        for (int i = 1; i < A.length; ++i) {
            int score = A[i] + A[top] - i + top;
            max = Math.max(max, score);
            if (A[top] - i + top < A[i]) top = i;
        }
        return max;
    }
}
