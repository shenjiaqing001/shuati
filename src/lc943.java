/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/30/22
 */
public class lc943 {

    public String shortestSuperstring(String[] words) {
        int n = words.length;
        char[][] wordsmap = new char[words.length][];
        int[][] dp = new int[n][n];


        for (int i = 0; i < words.length; ++i) {
            wordsmap[i] = words[i].toCharArray();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                for (int k = words[j].length(); k >= 0; --k) {
                    if (k > words[i].length()) continue;
                    int p = 0;
                    for (; p < k; ++p) {
                        if (wordsmap[i][words[i].length() - k + p] != wordsmap[j][p]) break;
                    }
                    if (p == k) {
                        dp[i][j] = k;
                        break;
                    }
                }
            }
        }
        String[][] memo = new String[n][1 << n + 4];
        String res = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            String str = words[i] + dfs(words, dp, memo, i, (1 << i));
            if (str.length() < min) {
                min = str.length();
                res = str;
            }
        }
        return res;
    }

    public String dfs(String[] words, int[][] dp, String[][] memo, int index, int state) {
        if (Integer.bitCount(state) == words.length) {
            return "";
        }
        if (memo[index][state] != null) {
            return memo[index][state];
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            if ((state & (1 << i)) == 0) {
                int k = dp[index][i];
                String tmp = words[i].substring(k) + dfs(words, dp, memo, i, state | (1 << i));
                if (tmp.length() < min) {
                    min = tmp.length();
                    res = tmp;
                }
            }
        }
        memo[index][state] = res;
        return res;
    }
}
