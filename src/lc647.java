/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc647 {

    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); ++i) {
            dfs(s, i, i);
            dfs(s, i, i + 1);
        }
        return count;
    }

    public void dfs(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            count++;
            left--;
            right++;
        }
    }
}
