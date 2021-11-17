package WeeklyContest267;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/14
 */
public class lc2076yao {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] res = new boolean[requests.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
            map2.put(i, new HashSet<>());
            map2.get(i).add(i);
        }

        for (int i = 0; i < restrictions.length; i++) {
            map.get(restrictions[i][0]).add(restrictions[i][1]);
            map.get(restrictions[i][1]).add(restrictions[i][0]);
        }

        for (int i = 0; i < requests.length; i++) {
            //已是朋友
            if (map2.get(requests[i][0]) == map2.get(requests[i][1])) {
                res[i] = true;
                continue;
            }
            //已是敌人
            if (map.get(requests[i][0]).contains(requests[i][1])) continue;

            //非敌非友
            boolean flag = true;

            int p1 = requests[i][0];
            int p2 = requests[i][1];
            for (int friend : map2.get(p1)) {
                if (map.get(p2).contains(friend)) {
                    flag = false;
                    break;
                }
            }
            for (int friend : map2.get(p2)) {
                if (map.get(p1).contains(friend)) {
                    flag = false;
                    break;
                }
            }

            //是朋友了
            if (flag) {
                res[i] = true;
                map2.get(p1).addAll(map2.get(p2));
                for (int num : map2.get(p2)) {
                    map2.put(num, map2.get(p1));
                }

                map.get(p1).addAll(map.get(p2));
                for (int num : map2.get(p2)) {
                    map.put(num, map.get(p1));
                }
            }
        }

        return res;
    }
}
