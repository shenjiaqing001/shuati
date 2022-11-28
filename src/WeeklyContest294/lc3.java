package WeeklyContest294;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/21/22
 */
public class lc3 {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) return 0;
        Arrays.sort(stockPrices, (o1, o2) -> (o1[0] - o2[0]));
        int res = 1;
        int n = stockPrices.length;
        for (int i = 2; i < n; ++i) {
            int leftx = stockPrices[i - 1][0] - stockPrices[i - 2][0];
            int lefty = stockPrices[i - 1][1] - stockPrices[i - 2][1];
            int rightx = stockPrices[i][0] - stockPrices[i - 1][0];
            int righty = stockPrices[i][1] - stockPrices[i - 1][1];
            if ((long) leftx * righty != (long) rightx * lefty) {
                res++;
            }
        }
        return res;
    }
}
