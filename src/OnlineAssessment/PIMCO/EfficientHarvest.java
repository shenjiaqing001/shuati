package OnlineAssessment.PIMCO;

import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class EfficientHarvest {
    public static long maxProfit(int k, List<Integer> profit) {
        // Write your code here
        int half = profit.size() / 2;
        long[] sum = new long[half + 1];
        for (int i = 1; i <= half; ++i) {
            sum[i] = sum[i - 1] + profit.get(i - 1) + profit.get(i - 1 + half);
        }

        long max = Long.MIN_VALUE;
        for (int i = k; i <= half; ++i) {
            max = Math.max(sum[i] - sum[i - k], max);
        }
        int left = half - k;
        long min = Long.MAX_VALUE;
        for (int i = left; i <= half; ++i) {
            min = Math.min(sum[i] - sum[i - left], min);
        }
        System.out.println(max + " " + min);
        min = sum[half] - min;
        return Math.max(min, max);
    }
}
