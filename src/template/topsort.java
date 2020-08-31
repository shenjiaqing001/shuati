package template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class topsort {
    public List<Integer> topsort(int num, int[][] prerequisites) {
        List<Integer>[] pre = new List[num];
        int[] preCount = new int[num];
        for (int i = 0; i < num; ++i) {
            pre[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            pre[prerequisites[i][0]].add(prerequisites[i][1]);
            preCount[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < num; ++i) {
            if (preCount[i] == 0)
                q.add(i);
        }
        List<Integer> res = new LinkedList<>();
        while (!q.isEmpty()) {
            int tmp = q.poll();
            res.add(tmp);
            for (int i = 0; i < pre[tmp].size(); ++i) {
                preCount[pre[tmp].get(i)]--;
                if (preCount[pre[tmp].get(i)] == 0)
                    q.add(pre[tmp].get(i));
            }
        }

        if (res.size() == num) return res;
        else return null;
    }
}
