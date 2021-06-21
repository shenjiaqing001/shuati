package WeeklyContest246;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/20
 */
public class lc1906 {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] dp = new int[n + 1][101];

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 1; j <= 100; ++j) {
                dp[i + 1][j] = dp[i][j];
            }
            dp[i + 1][nums[i]]++;
        }
        int[] res = new int[queries.length];


        for (int i = 0; i < queries.length; ++i) {
            int[] count = new int[101];
            for (int j = 1; j <= 100; ++j) {
                count[j] = dp[queries[i][1] + 1][j] - dp[queries[i][0]][j];
            }

            int min = Integer.MAX_VALUE;
            int last = -1;
            for (int j = 1; j <= 100; ++j) {
                if (count[j] >= 1) {
                    if (last != -1)
                        min = Math.min(min, j - last);
                    last = j;
                }
            }
            if (min == Integer.MAX_VALUE) min = -1;
            res[i] = min;
        }
        return res;
    }
}
