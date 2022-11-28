package WeeklyContest311;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/22
 */
public class lc4 {
    public int[] sumPrefixScores(String[] words) {
        Map<Long, Integer> map = new HashMap<>();
        long base = 29;
        for (String word : words) {
            long hash = 0;
            for (char c : word.toCharArray()) {
                hash = hash * base + c - 'a' + 1;
                map.put(hash, map.getOrDefault(hash, 0) + 1);
            }
        }
        int index = 0;
        int[] res = new int[words.length];
        for (String word : words) {
            long hash = 0;
            int count = 0;
            for (char c : word.toCharArray()) {
                hash = hash * base + c - 'a' + 1;
                count += map.get(hash);
            }
            res[index++] = count;
        }
        return res;
    }
}
