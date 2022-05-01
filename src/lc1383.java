import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/24/22
 */
public class lc1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; ++i) {
            matrix[i][0] = speed[i];
            matrix[i][1] = efficiency[i];
        }
        Arrays.sort(matrix, (o1, o2) -> (o2[1] - o1[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max = 0;
        long mod = 1_000_000_007;
        long sumSpeed = 0;
        long minEffi = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            minEffi = Math.min(minEffi, matrix[i][1]);
            sumSpeed += matrix[i][0];
            pq.add(matrix[i][0]);
            if (pq.size() > k) {
                sumSpeed -= pq.poll();
            }
            max = Math.max(max, sumSpeed * minEffi);
        }
        max %= mod;
        return (int) max;
    }
}
