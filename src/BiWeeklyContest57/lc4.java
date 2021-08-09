package BiWeeklyContest57;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc4 {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int n = heights.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int ans = 0;
            while (!deque.isEmpty() && deque.peekLast() < heights[i]) {
                ans++;
                deque.pollLast();
            }
            if (!deque.isEmpty()) ans += 1;
            res[i] = ans;
            deque.add(heights[i]);
        }
        return res;
    }
}
