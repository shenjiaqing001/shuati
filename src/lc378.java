import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/8/20
 */
public class lc378 {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < matrix.length; ++i) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; ++i) {
            int[] now = pq.poll();
            System.out.println(now[0]);
            if (now[2] == matrix[0].length - 1) continue;
            pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
        }

        return pq.poll()[0];
    }
}
