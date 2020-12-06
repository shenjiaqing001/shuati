package WeeklyContest215;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/15
 */
public class lc5603 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if (count1[i] != 0 && count2[i] == 0) return false;
            if (count1[i] == 0 && count2[i] != 0) return false;
        }


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; ++i) {
            if (count1[i] != 0) {
                map.put(count1[i], map.getOrDefault(count1[i], 0) + 1);
            }
        }

        for (int i = 0; i < 26; ++i) {
            if (count2[i] != 0) {
                if (!map.containsKey(count2[i]) || map.get(count2[i]) == 0) return false;
                map.put(count2[i], map.get(count2[i]) - 1);
            }
        }

        return true;
    }
}
