import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc973 {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < points.length; ++i) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            q.offer(new int[]{dis, points[i][0], points[i][1]});
            if (q.size() > K) q.poll();
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < q.size(); ++i) {
            int[] now = q.poll();
            System.out.println(now[0]+" "+ now[1] + " "+ now[2] );
            res[i][0] = now[1];
            res[i][1] = now[2];
        }
        return res;
    }

}
