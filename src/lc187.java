import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/18/20
 */
public class lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 9; i < s.length(); ++i) {
            String tmp = s.substring(i - 9, i + 1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (map.get(tmp) == 2)
                res.add(tmp);
        }
        return res;
    }
}
