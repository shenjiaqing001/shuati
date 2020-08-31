import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < c.length; ++i) {
            if (!set.contains(c[i])) {
                set.add(c[i]);
                q.add(c[i]);
                max = Math.max(max, set.size());
            } else {
                while (!q.isEmpty() && q.peek() != c[i]) {
                    char tmp = q.poll();
                    set.remove(tmp);
                }
                q.poll();
                q.add(c[i]);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
