package WeeklyContest98;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; ++i) {
            if (isPattern(words[i], pattern))
                res.add(words[i]);
        }
        return res;
    }


    public boolean isPattern(String str, String pattern) {
        if (str.length() != pattern.length()) return false;
        char[] cs = str.toCharArray();
        char[] cp = pattern.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            if (map.containsKey(cp[i])) {
                if (map.get(cp[i]) != cs[i])
                    return false;
            } else {
                if(set.contains(cs[i]))
                    return false;
                map.put(cp[i], cs[i]);
                set.add(cs[i]);
            }
        }
        return true;
    }
}
