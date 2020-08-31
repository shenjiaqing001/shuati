import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/9/20
 */

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= i; ++j) {
                if (set.contains(s.substring(j - 1, i)) && flag[j - 1])
                    flag[i] = true;
            }
        }
        return flag[s.length()];
    }
}
