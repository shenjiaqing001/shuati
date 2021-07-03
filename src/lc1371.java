import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc1371 {
    public int findTheLongestSubstring(String s) {
        int[] count = new int[32];
        for (int i = 0; i < 32; ++i) count[i] = -1;
        count[0] = -1;
        int max = 0;
        int state = 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);

        for (int i = 0; i < c.length; ++i) {
            if (map.containsKey(c[i])) {
                int pos = map.get(c[i]);
                state ^= 1 << pos;
                if (count[state] == -1 && state != 0) {
                    count[state] = i;
                }
            }
            max = Math.max(max, i - count[state]);
        }
        return max;
    }
}
