import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/23/21
 */
public class lc676 {
    class MagicDictionary {

        Map<String, List<int[]>> map = new HashMap<>();

        public MagicDictionary() {
        }

        public void buildDict(String[] dict) {
            for (String s : dict) {
                for (int i = 0; i < s.length(); i++) {
                    String key = s.substring(0, i) + s.substring(i + 1);
                    int[] pair = new int[]{i, s.charAt(i)};

                    List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                    val.add(pair);

                    map.put(key, val);
                }
            }
        }

        public boolean search(String word) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(key)) {
                    for (int[] pair : map.get(key)) {
                        if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                    }
                }
            }
            return false;
        }
    }
}
