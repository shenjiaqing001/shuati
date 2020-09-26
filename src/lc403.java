import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc403 {
    public boolean canCross(int[] stones) {
        if (stones.length == 1) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; ++i) {
            if (!map.containsKey(stones[i]))
                map.put(stones[i], new HashSet<>());
        }
        return dfs(map, stones[0], 0, stones[stones.length - 1]);
    }

    public boolean dfs(Map<Integer, Set<Integer>> map, int pos, int step, int end) {
        if (pos == end) return true;
        if (!map.containsKey(pos)) return false;
        if (map.get(pos).contains(step)) return false;
        map.get(pos).add(step);

        for (int i = -1; i <= 1; ++i) {
            int nextStep = step + i;
            if (nextStep <= 0) continue;
            if (dfs(map, pos + nextStep, nextStep, end)) return true;
        }

        return false;
    }
}
