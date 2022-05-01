import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/18/22
 */
public class lc828 {
    public int uniqueLetterString(String s) {
        char[] c = s.toCharArray();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < c.length; ++i) {
            map.putIfAbsent(c[i] - 'A', new ArrayList<>());
            map.get(c[i] - 'A').add(i);
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                for (int j = 0; j < list.size(); ++j) {
                    int left = j == 0 ? -1 : list.get(j - 1);
                    int right = j == list.size() - 1 ? c.length : list.get(j + 1);
                    res += (list.get(j) - left) * (right - list.get(j));
                }
            }
        }
        return res;
    }
}
