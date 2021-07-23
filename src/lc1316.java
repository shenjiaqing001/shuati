import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/23
 */
public class lc1316 {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        long[][] dp = new long[n][n];
        char[] c = text.toCharArray();
        long base = 26;

        for (int i = 0; i < n; ++i) {
            long str = 0;
            for (int j = i; j < n; ++j) {
                str = 26 * str + c[j];
                dp[i][j] = str;
            }
        }

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i + j + j + 1 >= n) break;
                if (dp[i][i + j] == dp[i + j + 1][i + j + 1 + j]) set.add(dp[i][i + j]);
            }
        }

        return set.size();
    }
}
