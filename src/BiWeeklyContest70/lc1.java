package BiWeeklyContest70;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc1 {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int tmp = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            if (tmp == 0 || tmp == 1) {
                res += cost[i];
                tmp++;
            } else {
                tmp = 0;
            }
        }
        return res;
    }
}
