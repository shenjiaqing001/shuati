package z.template;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class topsort {
    public List<Integer> topsort(int num, int[][] prerequisites) {
        // pre[i] 表示 i 课程有多少门后置课
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        // preCount[i] 表示 i 课程有多少门前置课
        int[] preCount = new int[num];

        for (int[] prerequisite : prerequisites) {
            preMap.putIfAbsent(prerequisite[0], new ArrayList<>());
            preMap.get(prerequisite[0]).add(prerequisite[1]);
            preCount[prerequisite[1]]++;
        }

        // 如果前置课数量 = 0，可以直接上，扔到q里面去
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num; ++i) {
            if (preCount[i] == 0)
                q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            res.add(now);
            if (!preMap.containsKey(now)) continue;
            // 所有的后置课的preCount -= 1，如果=0，扔到q
            for (Integer next : preMap.get(now)) {
                preCount[next]--;
                if (preCount[next] == 0)
                    q.add(next);
            }
        }

        if (res.size() == num) return res;
        else return null;
    }
}
