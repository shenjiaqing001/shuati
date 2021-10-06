/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/6
 */
public class lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int max = 0;
        for (int i = 0; i < k; ++i) {
            sum += cardPoints[i];
        }
        max = sum;
        for (int i = k - 1; i >= 0; --i) {
            sum -= cardPoints[i];
            sum += cardPoints[n + (i - k)];
            max = Math.max(max, sum);
        }
        return max;
    }
}
