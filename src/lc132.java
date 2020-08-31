import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/20
 */
public class lc132 {

    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            int min = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) &&
                        (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[j][i] = true;
                    dp[i][j] = true;
                    if (j == 0)
                        min = 0;
                    else
                        min = Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[s.length() - 1];
    }

    public static void main(String[] args) {
        lc132 t = new lc132();
        System.out.println(t.minCut("aab"));
    }
}
