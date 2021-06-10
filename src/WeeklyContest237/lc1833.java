package WeeklyContest237;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/21
 */
public class lc1833 {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (coins >= costs[i]) {
                res++;
                coins -= costs[i];
            } else break;

        }
        return res;
    }
}
