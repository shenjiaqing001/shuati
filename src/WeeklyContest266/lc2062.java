package WeeklyContest266;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/6
 */
public class lc2062 {


    public int countVowelSubstrings(String word) {
        char[] c = word.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length; ++i) {
            for (int j = i + 4; j < c.length; ++j) {
                Map<Character, Integer> map = new HashMap<>();
                boolean flag = true;
                for (int k = i; k <= j; ++k) {
                    if (c[k] == 'a' || c[k] == 'e' || c[k] == 'i' || c[k] == 'o' || c[k] == 'u') {

                    } else {
                        flag = false;
                        break;
                    }
                    map.put(c[k], map.getOrDefault(c[k], 0) + 1);
                }
                if (flag && map.size() == 5) res++;
            }
        }
        return res;
    }
}
