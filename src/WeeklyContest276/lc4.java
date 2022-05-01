package WeeklyContest276;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/15/22
 */
public class lc4 {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        int length = batteries.length;
        long[] preSum = new long[batteries.length];
        preSum[0] = batteries[0];
        for (int i = 1; i < length - n + 1; ++i) {
            preSum[i] = preSum[i - 1] + batteries[i];
        }

        for (int i = length - n + 1; i < length; ++i) {
            if (batteries[i] >= preSum[i - 1] / (n - length + i))
                batteries[i] = (int) preSum[i - 1] / (n - length + i);
            preSum[i] = preSum[i - 1] + batteries[i];
        }
        return preSum[length - 1] / n;
    }

    public long maxRunTime2(int n, int[] batteries) {
        Arrays.sort(batteries);
        int length = batteries.length;
        long sum = 0;
        for (int i = 0; i < length - n + 1; i++) {
            sum += batteries[i];
        }
        for (int i = length - n + 1; i < length; i++) {
            sum += Math.min(sum / (n - length + i), batteries[i]);
        }
        return sum / n;
    }


    public static void main(String[] args) {
        lc4 test = new lc4();
        test.maxRunTime(9, new int[]{18, 54, 2, 53, 87, 31, 71, 4, 29, 25});
    }
}
