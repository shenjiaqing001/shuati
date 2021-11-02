package WeeklyContest265;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Set<Integer> set = new HashSet<>();
        set.add(start);
        int step = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int now = q.poll();
                for (int num : nums) {
                    for (int next : new int[]{now + num, now - num, now ^ num}) {
                        if (next == goal) return step;
                        if (next >= 0 && next <= 1000 && !set.contains(next)) {
                            set.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
