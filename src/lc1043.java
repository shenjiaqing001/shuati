

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
//        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            int max = 0;
            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                max = Math.max(max, arr[j]);
                if (j >= 1) {
                    dp[i] = Math.max(dp[i], dp[j - 1] + max * (i - j + 1));
                } else {
                    dp[i] = Math.max(dp[i], max * (i + 1));
                }
            }
        }
        return dp[n - 1];
    }
}
