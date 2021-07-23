import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/7
 */
public class lc1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);

        for (int i = 1; i < points.length; ++i) {
            while (!deque.isEmpty() && points[deque.peekFirst()][0] < points[i][0] - k)
                deque.pollFirst();

            if (deque.isEmpty()) deque.addLast(i);
            else {
                int index = deque.peekFirst();
                int val = points[i][1] + points[index][1] + points[i][0] - points[index][0];
                max = Math.max(val, max);

                while (!deque.isEmpty() && points[deque.peekLast()][1] <=
                        points[i][1] - points[i][0] + points[deque.peekLast()][0])
                    deque.pollLast();
                deque.addLast(i);
            }
        }
        return max;
    }
}
