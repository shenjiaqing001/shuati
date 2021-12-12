package WeeklyContest270;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/4/21
 */
public class lc2097 {
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    List<Integer> result = new LinkedList<>();

    public int[][] validArrangement(int[][] pairs) {
        if (pairs.length == 1) return pairs;
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] pair : pairs) {
            count.put(pair[0], count.getOrDefault(pair[0], 0) + 1);
            count.put(pair[1], count.getOrDefault(pair[1], 0) - 1);
        }
        int num = -1;
        for (int key : count.keySet()) {
            if (count.get(key) == 1) {
                num = key;
            }
        }
        if (num == -1) {
            for (int key : count.keySet()) {
                num = key;
                break;
            }
        }

        for (int[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                PriorityQueue<Integer> q = new PriorityQueue<>();
                map.put(pair[0], q);
            }
            map.get(pair[0]).add(pair[1]);
        }
        dfs(num);
        int[][] res = new int[pairs.length][2];
        int index = 0;

        for (int tmp : result) {
            if (index > 0)
                res[index - 1][1] = tmp;
            res[index][0] = tmp;
            index ++;
        }

        return res;
    }

    public void dfs(int s) {
        PriorityQueue<Integer> q = map.get(s);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }
        result.add(0, s);
    }

}
