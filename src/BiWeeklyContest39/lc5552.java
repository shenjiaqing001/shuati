package BiWeeklyContest39;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/14
 */
public class lc5552 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        for (int i = 0; i < forbidden.length; ++i) {
            leftSet.add(forbidden[i]);
            rightSet.add(forbidden[i]);
        }
        Queue<int[]> q = new LinkedList<>();
        leftSet.add(0);
        rightSet.add(0);
        q.add(new int[]{0, 0});
        if (x == 0) return 0;
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] p = q.poll();
                if (p[0] == x) return res;
                int idx = p[0] - b;

                if (idx >= 0 && !leftSet.contains(idx) && p[1] == 0) {
                    q.add(new int[]{idx, 1});
                    leftSet.add(idx);
                }
                idx = p[0] + a;
                if (!rightSet.contains(idx) && idx <= 4000) {
                    q.add(new int[]{idx, 0});
                    rightSet.add(idx);
                }
            }
            res++;
        }
        return -1;
    }
}
