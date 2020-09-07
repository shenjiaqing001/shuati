import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/7/20
 */
public class lc290 {
    public boolean wordPattern(String pattern, String str) {
        String[] list = str.split(" ");
        if (list.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        char[] c = pattern.toCharArray();

        for (int i = 0; i < c.length; ++i) {
            if (map.containsKey(c[i])) {
                if (!list[i].equals(map.get(c[i]))) {
                    return false;
                }
            } else {
                if (set.contains(list[i])) return false;
                map.put(c[i], list[i]);
                set.add(list[i]);
            }
        }
        return true;
    }
}
