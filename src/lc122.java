/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int res = 0;
        int low = prices[0];
        int high = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < high) {
                res += (high - low);
                low = high = prices[i];
            } else {
                high = prices[i];
            }
        }
        res += (high - low);
        return res;
    }
}
