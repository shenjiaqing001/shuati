package WeeklyContest261;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (m + n);
        for (int roll : rolls) {
            total -= roll;
        }
        total -= n;
        if (total < 0 || total > 5 * n) return new int[]{};
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; ++i) {
            if (total >= 5) {
                total -= 5;
                res[i] = 6;
            } else {
                res[i] += total;
                total = 0;
            }
        }
        return res;
    }
}
