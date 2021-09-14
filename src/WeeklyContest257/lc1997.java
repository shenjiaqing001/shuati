package WeeklyContest257;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1997 {
    public static void main(String[] args) {
        lc1997 test = new lc1997();
        test.firstDayBeenInAllRooms(new int[]{0, 0, 2});
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] dp = new long[n];
        long[] preSum = new long[n + 1];
        dp[0] = 2;
        preSum[1] = 2;
        long mod = 1_000_000_007;
        for (int i = 1; i < n - 1; ++i) {
            dp[i] = 2 + preSum[i] + mod - preSum[nextVisit[i]];
            dp[i] %= mod;
            preSum[i + 1] = preSum[i] + dp[i];
            preSum[i + 1] %= mod;
        }

        return (int) (preSum[n - 1] % mod);
    }
}
