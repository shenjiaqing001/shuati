import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/4/21
 */
public class lc267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (s.length() % 2 == 0) {
            for (int value : map.values()) {
                if (value % 2 == 1) {
                    return new ArrayList<>();
                }
            }
        } else {
            boolean flag = false;
            for (int value : map.values()) {
                if (value % 2 == 1) {
                    if (flag) {
                        return new ArrayList<>();
                    } else {
                        flag = true;
                    }
                }
            }
        }
        String tmp = "";
        if (s.length() % 2 == 1) {
            for (char c : map.keySet()) {
                if (map.get(c) % 2 == 1) {
                    map.put(c, map.get(c) - 1);
                    tmp += c;
                }
            }
        }

        dfs(res, map, tmp, s.length());

        return res;
    }


    public void dfs(List<String> res, Map<Character, Integer> map, String s, int end) {
        if (s.length() == end) {
            res.add(s);
            return;
        }
        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 2);
                dfs(res, map, c + s + c, end);
                map.put(c, map.get(c) + 2);
            }
        }
    }

}
