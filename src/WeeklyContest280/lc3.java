package WeeklyContest280;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/12/22
 */
public class lc3 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long[] sum = new long[beans.length + 1];
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + beans[i - 1];
        }
        long min = Long.MAX_VALUE;
        long tmp_sum = 0;
        for (int i = 1; i < sum.length; ++i) {
            long tmp = 0;
            tmp = tmp_sum + sum[beans.length] - sum[i - 1] - (long)beans[i - 1] * (beans.length + 1 - i);
            min = Math.min(tmp, min);
            tmp_sum += beans[i - 1];
        }
        return min;
    }
}
