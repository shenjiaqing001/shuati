package WeeklyContest287;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/2/22
 */
public class lc2 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 0) res.get(0).add(key);
            if (map.get(key) == 1) res.get(1).add(key);
        }
        res.get(0).sort((Comparator.comparingInt(o -> o)));
        res.get(1).sort((Comparator.comparingInt(o -> o)));
        return res;
    }
}
