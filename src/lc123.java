/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int i = 0; i < prices.length; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        lc123 t = new lc123();
        int[] nums = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(t.maxProfit(nums));
    }
}
