package WeeklyContest282;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/26/22
 */
public class lc4 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int n = tires.length;
        int[] minArrays = new int[1000 + 1];

        Arrays.fill(minArrays, Integer.MAX_VALUE);
        minArrays[0] = 0;
        for (int i = 0; i < n; ++i) {
            int count = 1;
            long last = tires[i][0];
            long timeUsed = tires[i][0];
            minArrays[count] = (int) Math.min(minArrays[count], timeUsed);
            while (last * tires[i][1] + timeUsed <= Integer.MAX_VALUE) {
                count += 1;
                last *= tires[i][1];
                timeUsed += last;
                minArrays[count] = (int) Math.min(minArrays[count], timeUsed);
            }
        }
        int[] dp = new int[numLaps + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < numLaps; ++i) {
            for (int j = 1; j <= numLaps; ++j) {
                if (i + j > numLaps) continue;
                if (minArrays[j] == Integer.MAX_VALUE) continue;
                if ((long) dp[i] + minArrays[j] >= 200000000) continue;
                if (i == 0) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + minArrays[j]);
                } else {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + minArrays[j] + changeTime);
                }
            }
        }
        return dp[numLaps];
    }
}
