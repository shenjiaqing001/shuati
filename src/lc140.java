import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/9/20
 */
public class lc140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(s.length(), new ArrayList<>());
        calPath(s, set, map);


        List<String> res = new ArrayList<>();
        recursion(res, "", s, 0, map);
        return res;
    }

    public void calPath(String s, Set<String> set,
                        Map<Integer, List<Integer>> map) {
        for (int i = s.length(); i > 0; --i) {
            if (!map.containsKey(i))
                continue;
            for (int j = i - 1; j >= 0; --j) {
                String tmp = s.substring(j, i);
                if (set.contains(tmp)) {
                    if (map.containsKey(j)) {
                        map.get(j).add(i);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        map.put(j, list);
                    }
                }
            }
        }
    }

    public void recursion(List<String> res, String tmp, String s, int pos,
                          Map<Integer, List<Integer>> map) {
        if (pos == s.length()) {
            res.add(tmp);
            return;
        }
        if (!map.containsKey(pos)) return;

        List<Integer> list = map.get(pos);
        for (int i = 0; i < list.size(); ++i) {
            if (tmp.equals(""))
                recursion(res, tmp + s.substring(pos, list.get(i)), s,
                        list.get(i), map);
            else recursion(res, tmp + " " + s.substring(pos, list.get(i)), s,
                    list.get(i), map);
        }
    }
}
