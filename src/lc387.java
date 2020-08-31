import java.util.Map;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc387 {
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        int[] count = new int[26];
        int[] first = new int[26];
        for (int i = 0; i < 26; ++i) first[i] = -1;
        for (int i = c.length - 1; i >= 0; --i) {
            if (count[c[i] - 'a'] == 0) {
                first[c[i] - 'a'] = i;
            }
            count[c[i] - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {
            if (count[i] == 1) {
                min = Math.min(min, first[i]);
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        else return min;
    }
}
