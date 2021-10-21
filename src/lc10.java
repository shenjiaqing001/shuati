/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/20
 */
public class lc10 {
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public boolean dfs(char[] s, char[] p, int index1, int index2) {
        if (index2 == p.length) {
            if (index1 == s.length) return true;
            else return false;
        }

        if (p[index2] == '.') {
            if (index2 + 1 != p.length && p[index2 + 1] == '*') {
                for (int i = index1 - 1; i < s.length; ++i) {
                    if (dfs(s, p, i + 1, index2 + 2)) return true;
                }
                return false;
            } else {
                if (index1 == s.length) return false;
                return dfs(s, p, index1 + 1, index2 + 1);
            }
        } else {
            if (index2 + 1 != p.length && p[index2 + 1] == '*') {
                if (dfs(s, p, index1, index2 + 2)) return true;
                for (int i = index1; i < s.length; ++i) {
                    if (s[i] == p[index2]) {
                        if (dfs(s, p, i + 1, index2 + 2)) return true;
                    } else {
                        break;
                    }
                }
                return false;
            } else {
                if (index1 == s.length) return false;
                if (s[index1] != p[index2]) return false;
                return dfs(s, p, index1 + 1, index2 + 1);
            }
        }
    }
}
