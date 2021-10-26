import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/24
 */
public class lc528 {
    class Solution {
        int[] preSum;
        int[] w;
        Random random = new Random();
        int total;

        public Solution(int[] w) {
            this.w = w;
            preSum = new int[w.length + 1];
            for (int i = 1; i <= w.length; ++i) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
            total = preSum[w.length];
        }

        public int pickIndex() {
            int r = random.nextInt(total) + 1;
            int lo = 1;
            int hi = w.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (preSum[mid] < r) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo - 1;
        }
    }
}
