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
        List<Integer>[] pre = new List[num];
        // preCount[i] 表示 i 课程有多少门前置课
        int[] preCount = new int[num];
        for (int i = 0; i < num; ++i) {
            pre[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            pre[prerequisites[i][0]].add(prerequisites[i][1]);
            preCount[prerequisites[i][1]]++;
        }

        // 如果前置课数量 = 0，可以直接上，扔到q里面去
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num; ++i) {
            if (preCount[i] == 0)
                q.add(i);
        }
        List<Integer> res = new LinkedList<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            res.add(now);
            // 所有的后置课的preCount -= 1，如果=0，扔到q
            for (int i = 0; i < pre[now].size(); ++i) {
                int next = pre[now].get(i);
                preCount[next]--;
                if (preCount[next] == 0)
                    q.add(pre[now].get(i));
            }
        }

        if (res.size() == num) return res;
        else return null;
    }
}
