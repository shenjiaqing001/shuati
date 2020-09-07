import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/8/20
 */
public class lc249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] c = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            int trans = c[0] - 'a';
            for (int i = 0; i < str.length(); ++i) {
                int tmp = c[i] - trans;
                if (tmp < 'a') tmp += 26;
                sb.append((char) tmp);
            }
            String s = sb.toString();
            map.putIfAbsent(s, new LinkedList<>());
            map.get(s).add(str);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
