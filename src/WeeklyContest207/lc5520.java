package WeeklyContest207;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/20
 */
public class lc5520 {
    int max = 0;

    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet<>());
        return max;
    }

    public void dfs(String s, int index, Set<String> set) {
        if (index == s.length()) {
            max = Math.max(set.size(), max);
            return;
        }
        for (int i = index + 1; i <= s.length(); ++i) {
            String str = s.substring(index, i);
            if (set.contains(str)) continue;
            set.add(str);
            dfs(s, i, set);
            set.remove(str);
        }
    }

}
