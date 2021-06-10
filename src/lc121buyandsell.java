/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/16
 */
public class lc121buyandsell {
    public int maxProfit(int[] prices) {
        int res = 0;
        int max = 0;
        int min = 0;


        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < max) {
                res += Math.max(0, max - min);
                min = prices[i];
                max = min;
            } else {
                max = prices[i];
            }
        }
        res += max - min;

        return res;
    }
}
