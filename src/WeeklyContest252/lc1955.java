package WeeklyContest252;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/31
 */
public class lc1955 {
    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;
        long[] sum = new long[3];
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) sum[0] = (2 * sum[0] + 1) % mod;
            if (nums[i] == 1) sum[1] = (2 * sum[1] + sum[0]) % mod;
            if (nums[i] == 2) sum[2] = (2 * sum[2] + sum[1]) % mod;
            System.out.println(sum[0] + " " + sum[1] + " " + sum[2]);
        }


        return (int) (sum[2] % 1_000_000_007);
    }
}
