package BiWeeklyContest61;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/18
 */
public class lc2008 {
    public static void main(String[] args) {
        lc2008 test = new lc2008();
        test.maxTaxiEarnings(10,
                new int[][]{{9, 10, 2}, {4, 5, 6}, {6, 8, 1}, {1, 5, 5}, {4, 9, 5}, {1, 6, 5}, {4, 8, 3}, {4, 7, 10}, {1, 9, 8}, {2, 3, 5}});
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        long res = 0;
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (o1, o2) -> o1[0] - o2[0]);
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            while (index < rides.length && rides[index][0] == i) {
                dp[rides[index][1]] = Math.max(dp[rides[index][1]],
                        dp[rides[index][0]] + rides[index][1] - rides[index][0] + rides[index][2]);
            }
        }
        return dp[n];
    }
}
