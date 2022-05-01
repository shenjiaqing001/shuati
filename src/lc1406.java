/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/19/22
 */
public class lc1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 5];
        int sum = 0;
        for (int i = n - 1; i >= 0; --i) {
            int max = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for (int j = i + 1; j <= i + 3; ++j) {
                max = Math.max(max, sum - dp[j]);
            }
            dp[i] = max;
        }
        int A = dp[0];
        int B = sum - dp[0];
        return A == B ? "Tie" : A > B ? "Alice" : "Bob";
    }
}
