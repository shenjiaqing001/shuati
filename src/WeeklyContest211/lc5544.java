package WeeklyContest211;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class lc5544 {
    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> set = new TreeSet<>();
        dfs(set, s, a, b);
        return set.first();
    }

    public void dfs(TreeSet<String> set, String s, int a, int b) {
        String rotate = s.substring(s.length() - b) + s.substring(0, s.length() - b);
        if (!set.contains(rotate)) {
            set.add(rotate);
            dfs(set, rotate, a, b);
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i += 2) {
            char c = sb.charAt(i);
            c += a;
            if (c > '9') c -= 10;
            sb.setCharAt(i, c);
        }
        String add = sb.toString();
        if (!set.contains(add)) {
            set.add(add);
            dfs(set, add, a, b);
        }
    }

}
