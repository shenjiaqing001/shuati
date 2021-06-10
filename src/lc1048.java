import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/18
 */
public class lc1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int max = 0;
            for (int i = 0; i < word.length(); ++i) {
                String tmp = word.substring(0, i) + word.substring(i + 1);
                max = Math.max(max, map.getOrDefault(tmp, 0) + 1);
            }
            map.put(word, max);
            res = Math.max(max, res);
        }
        return res;
    }
}
