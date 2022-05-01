package BiWeeklyContest69;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc3 {
    public int longestPalindrome(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int num = (s.charAt(0) - 'a') * 26 + (s.charAt(1) - 'a');
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        int count = 0;
        int once = 0;
        for (char i = 'a'; i <= 'z'; ++i) {
            for (char j = i; j <= 'z'; ++j) {
                int num = (i - 'a') * 26 + (j - 'a');
                int numv = (j - 'a') * 26 + (i - 'a');
                if (map.containsKey(num) && map.containsKey(numv)) {
                    if (i == j) {
                        count += map.get(num) / 2;
                        if (map.get(num) % 2 == 1) once++;
                    } else {
                        count += Math.min(map.get(num), map.get(numv));
                    }
                }
            }
        }

        int res = 0;
        res += count * 4;
        if (once >= 1) res += 2;
        return res;
    }
}
