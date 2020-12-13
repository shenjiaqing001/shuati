package BiWeeklyContest41;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/13
 */
public class lc1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sum = new int[n][3];
        for (int i = 0; i < n; ++i) {
            sum[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }

        Arrays.sort(sum, (a, b) -> Integer.compare(b[0], a[0]));
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) res += sum[i][1];
            else res -= sum[i][2];
        }
        return res == 0 ? 0 : res > 1 ? 1 : -1;
    }
}
