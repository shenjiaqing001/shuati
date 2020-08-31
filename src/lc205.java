import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> toMap = new HashMap<>();
        boolean[] flag = new boolean[256];

        for (int i = 0; i < s.length(); ++i) {
            if (toMap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != toMap.get(s.charAt(i)))
                    return false;
                else
                    continue;
            }
            if (flag[t.charAt(i)]) return false;

            toMap.put(s.charAt(i), t.charAt(i));
            flag[t.charAt(i)] = true;
        }
        return true;
    }
}
