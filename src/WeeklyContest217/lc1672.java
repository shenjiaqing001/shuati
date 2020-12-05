package WeeklyContest217;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/5
 */
public class lc1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; ++i) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; ++j) {
                sum += accounts[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
