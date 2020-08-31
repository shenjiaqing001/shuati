/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc121 {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < low) {
                max = Math.max(max, high - low);
                low = prices[i];
                high = low;
            } else {
                if (prices[i] > high) {
                    high = prices[i];
                    max = Math.max(max, high - low);
                }
            }
        }
        return max;
    }
}
