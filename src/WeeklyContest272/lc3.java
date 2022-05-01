package WeeklyContest272;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/18/21
 */
public class lc3 {
    public long getDescentPeriods(int[] prices) {
        long res = 1;
        long last = 1;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] == prices[i - 1] - 1) last += 1;
            else last = 1;
            res += last;
        }
        return res;
    }
}
