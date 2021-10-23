import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}
