/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = 10000;
        int res = 0;
        for (int i = 0; i < prices.length; ++i) {
            max = Math.max(prices[i], max);
            res = Math.max(res, max - min);
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }
        return res;
    }
}
