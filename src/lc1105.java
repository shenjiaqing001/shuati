import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/12
 */
public class lc1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1_000_000);

        for (int i = 0; i < n; ++i) {
            int width = 0;
            int height = 0;
            for (int j = i; j >= 0; --j) {
                width += books[j][0];
                if (width > shelfWidth) break;
                else {
                    height = Math.max(height, books[j][1]);
                    if (j == 0) dp[i] = Math.min(dp[i], height);
                    else dp[i] = Math.min(dp[i], dp[j - 1] + height);
                }
            }
        }
        return dp[n - 1];
    }
}
