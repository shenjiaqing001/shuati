package WeeklyContest289;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc4 {
    int max = 1;
    Map<Integer, List<Integer>> map = new HashMap<>();
    char[] c;

    public List<Integer> dfs(int num) {
        List<Integer> list = new ArrayList<>();
        if (map.containsKey(num)) {
            for (int child : map.get(num)) {
                List<Integer> tmp = dfs(child);
                if (c[num] != c[child]) {
                    list.add(tmp.get(0) + 1);
                }
            }
        }

        if (list.size() == 0) {
            list.add(1);
            return list;
        }
        if (list.size() < 2) {
            max = Math.max(max, list.get(0));
        } else {
            list.sort((o1, o2) -> o2 - o1);
            max = Math.max(max, list.get(0) + list.get(1) - 1);
        }
        return list;
    }

    public int longestPath(int[] parent, String s) {
        c = s.toCharArray();
        for (int i = 0; i < parent.length; ++i) {
            map.putIfAbsent(parent[i], new ArrayList<>());
            map.get(parent[i]).add(i);
        }
        dfs(map.get(-1).get(0));
        return max;
    }
}
