import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/29
 */
public class lc784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(S), 0);
        return res;
    }

    public void dfs(List<String> res, StringBuilder sb, int i) {
        if (i == sb.length()) {
            res.add(sb.toString());
            return;
        }

        if (sb.charAt(i) <= '9' && sb.charAt(i) >= '0') {
            dfs(res, sb, i + 1);
        } else {
            if (Character.isLowerCase(sb.charAt(i))) {
                char now = sb.charAt(i);
                dfs(res, sb, i + 1);
                sb.setCharAt(i, (char) ('A' + (now - 'a')));
                dfs(res, sb, i + 1);
                sb.setCharAt(i, now);
            } else {
                char now = sb.charAt(i);
                dfs(res, sb, i + 1);
                sb.setCharAt(i, (char) ('a' + (now - 'A')));
                dfs(res, sb, i + 1);
                sb.setCharAt(i, now);
            }
        }
    }
}
