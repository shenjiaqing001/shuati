import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/6
 */
public class lc1525 {
    public int numSplits(String s) {
        Map<Character, Integer> right = new HashMap<>();
        Map<Character, Integer> left = new HashMap<>();
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            left.put(c, left.getOrDefault(c, 0) + 1);
            right.put(c, right.get(c) - 1);
            if (right.get(c) == 0) right.remove(c);
            if (left.size() == right.size()) res++;
        }
        return res;
    }
}
