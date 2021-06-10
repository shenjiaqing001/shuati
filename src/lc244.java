import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/21
 */
public class lc244 {
    class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; ++i) {
                map.putIfAbsent(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int min = Integer.MAX_VALUE;
            for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
                int index1 = l1.get(i);
                int index2 = l2.get(j);
                if (index1 < index2) {
                    min = Math.min(index2 - index1, min);
                    i++;
                } else {
                    min = Math.min(index1 - index2, min);
                    j++;
                }
            }
            return min;
        }
    }

}
