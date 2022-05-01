import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/20
 */
public class lc131 {


    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) &&
                        (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[j][i] = true;
                    dp[i][j] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        find(res, new ArrayList<>(), s, 0, dp);
        return res;
    }

    public void find(List<List<String>> res, List<String> tmp, String s,
                     int pos, boolean[][] dp) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = pos; i < s.length(); ++i) {
            if (dp[i][pos]) {
                tmp.add(s.substring(pos, i + 1));
                find(res, tmp, s, i + 1, dp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        lc131 t = new lc131();
        System.out.println(t.partition("aab"));
    }
}
