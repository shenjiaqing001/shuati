package WeeklyContest309;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/3/22
 */
public class lc1 {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (map.containsKey(c[i])) {
                int last = map.get(c[i]);
                if (i - last == distance[c[i] - 'a'] + 1) {
                    continue;
                } else {
                    return false;
                }
            } else {
                map.put(c[i], i);
            }
        }
        return true;
    }
}
