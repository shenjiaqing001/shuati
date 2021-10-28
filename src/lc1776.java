import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/27
 */
public class lc1776 {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        Deque<Integer> deque = new ArrayDeque<>();
        // pos speed
        for (int i = n - 1; i >= 0; --i) {
            double tmp = -1;
            while (!deque.isEmpty() && cars[deque.peekLast()][1] >= cars[i][1])
                deque.pollLast();

            while (!deque.isEmpty() && cars[deque.peekLast()][1] < cars[i][1]) {
                int last = deque.peekLast();
                double t = 1.0 * (cars[last][0] - cars[i][0]) / cars[i][1] - cars[last][1];
                tmp = t;
                if (t >= res[last] && res[last] != -1) {
                    deque.pollLast();
                } else {
                    break;
                }
            }
            res[i] = tmp;
            deque.addLast(i);
        }
        return res;
    }
}
