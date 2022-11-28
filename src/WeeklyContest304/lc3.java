package WeeklyContest304;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/30/22
 */
public class lc3 {


    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int step1 = 0;
        while (true) {
            map1.put(node1, step1);
            node1 = edges[node1];
            if (node1 == -1) break;
            if (map1.containsKey(node1)) break;
            step1++;
        }

        int step2 = 0;
        while (true) {
            map2.put(node2, step2);
            node2 = edges[node2];
            if (node2 == -1) break;
            if (map2.containsKey(node2)) break;
            step2++;
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i <= 100000; ++i) {
            if (map1.containsKey(i) && map2.containsKey(i)) {
                if (Math.max(map1.get(i), map2.get(i)) < min) {
                    min = Math.max(map1.get(i), map2.get(i));
                    index = i;
                }
            }
        }
        return index;
    }
}
