package BiWeeklyContest68;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc2 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
                                       String[] supplies) {
        List<String> res = new ArrayList<>();

        Map<String, Integer> pre = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            pre.put(recipes[i], ingredients.get(i).size());
            for (String in : ingredients.get(i)) {
                map.putIfAbsent(in, new ArrayList<>());
                map.get(in).add(recipes[i]);
            }
        }

        Queue<String> q = new ArrayDeque<>();
        for (String s : supplies) q.add(s);

        while (!q.isEmpty()) {
            String now = q.poll();
            if (!map.containsKey(now)) continue;
            for (String s : map.get(now)) {
                pre.put(s, pre.get(s) - 1);
                if (pre.get(s) == 0) {
                    res.add(s);
                    q.add(s);
                }
            }
        }
        return res;
    }
}
