package OnlineAssessment.ebay;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class q4 {
    int max(int[] prices, int[] algo, int k) {
        // int max = 0;  删掉了
        int res = 0;
        int n = prices.length;
        for (int i = 0; i < n; ++i) {
            if (algo[i] == 0) res -= prices[i];
            else res += prices[i];
        }

        int max = res;
        for (int i = 0; i < n; ++i) {
            if (algo[i] == 0) res += 2 * prices[i];
            if (i >= k) {
                if (algo[i - k] == 0) res -= 2 * prices[i - k];
            }
            max = Math.max(max, res);
        }

        return max;
    }

}
