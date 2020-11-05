import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/5
 */
public class lc1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            if (map.containsKey(chars.charAt(i))) {
                map.put(chars.charAt(i), map.get(chars.charAt(i)) + 1);
            } else {
                map.put(chars.charAt(i), 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            int len = 0;
            HashMap<Character, Integer> hashmap = new HashMap<>();
            hashmap.putAll(map);
            for (int j = 0; j < words[i].length(); j++) {
                if (hashmap.containsKey(words[i].charAt(j)) &&
                        hashmap.get(words[i].charAt(j)) > 0) {
                    hashmap.put(words[i].charAt(j), hashmap.get(words[i].charAt(j)) - 1);
                    len++;
                }
            }
            if (len == words[i].length()) {
                sum += len;
            }
        }
        return sum;
    }
}
