/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/2
 */
public class lc44 {
    public boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder();
        char last = '?';
        for (char c : p.toCharArray()) {
            if (last == '*' && c == '*') {
                continue;
            } else {
                sb.append(c);
                last = c;
            }
        }
        p = sb.toString();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        return dfs(dp, s, p, 0, 0);
    }

    public boolean dfs(boolean[][] dp, String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (dp[sIndex][pIndex]) return false;
        int stmp = sIndex;
        int ptmp = pIndex;

        while (sIndex < s.length() && pIndex < p.length()) {
            if (p.charAt(pIndex) == '?') {
                pIndex++;
                sIndex++;
            } else if (p.charAt(pIndex) == '*') {
                boolean flag = false;
                for (int i = sIndex; i <= s.length(); ++i) {
                    if (dfs(dp, s, p, i, pIndex + 1)) return true;
                }
                dp[stmp][ptmp] = true;
                return false;
            } else {
                if (p.charAt(pIndex) == s.charAt(sIndex)) {
                    pIndex++;
                    sIndex++;
                } else {
                    dp[stmp][ptmp] = true;
                    return false;
                }
            }
        }
        dp[stmp][ptmp] = true;

        if (sIndex != s.length()) return false;
        while (pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
        if (pIndex != p.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        lc44 test = new lc44();
        test.isMatch("acdcb", "a*c?b");
    }
}
