/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/31/21
 */
public class lc1340 {
    public int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, dfs(arr, dp, d, i));
        }
        return max;
    }

    public int dfs(int[] arr, int[] dp, int d, int cur) {
        if (dp[cur] != 0) return dp[cur];
        int max = 0;

        for (int i = 1; i <= d; ++i) {
            if (cur + i < arr.length && arr[cur] > arr[cur + i]) {
                max = Math.max(max, dfs(arr, dp, d, cur + i));
            } else break;
        }
        for (int i = 1; i <= d; ++i) {
            if (cur - i >= 0 && arr[cur] > arr[cur - i]) {
                max = Math.max(max, dfs(arr, dp, d, cur - i));
            } else break;
        }
        dp[cur] = max + 1;
        return dp[cur];
    }
}
