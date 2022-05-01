import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/25/22
 */
public class lc1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int res = 0;
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        for (int i = 0; i < n / 2; i++) {
            res += (costs[i][0] + costs[i + n / 2][1]);
        }
        return res;
    }
}
