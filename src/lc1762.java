import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/2
 */
public class lc1762 {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < heights.length; ++i) {
            while (!q.isEmpty() && heights[q.peekLast()] <= heights[i]) q.pollLast();
            q.offerLast(i);
        }
        int[] res = new int[q.size()];
        int index = 0;
        while (!q.isEmpty()) res[index++] = q.pollFirst();
        return res;
    }
}
