import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/24
 */
public class lc1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); ++j) {
                mask |= 1 << (words[i].charAt(j) - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        for (String puzzle : puzzles) {
            int mask = 0;
            for (int j = 0; j < puzzle.length(); ++j) {
                mask |= 1 << (puzzle.charAt(j) - 'a');
            }

            int sub = mask;
            int first = 1 << (puzzle.charAt(0) - 'a');
            int count = 0;
            while (true) {
                if ((sub & first) == first && map.containsKey(sub)) {
                    count += map.get(sub);
                }
                if (sub == 0) break;
                sub = (sub - 1) & mask;
            }
            res.add(count);
        }
        return res;
    }
}
