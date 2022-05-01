import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // distance worker bike
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int comp = Integer.compare(a[0], b[0]);
                if (comp == 0) {
                    comp = Integer.compare(a[1], b[1]);
                    if (comp == 0) {
                        comp = Integer.compare(a[2], b[2]);
                    }
                }
                return comp;
            }
        });

        for (int i = 0; i < workers.length; ++i) {
            for (int j = 0; j < bikes.length; ++j) {
                pq.add(new int[]{Math.abs(workers[i][0] - bikes[j][0]) +
                        Math.abs(workers[i][1] - bikes[j][1]), i, j});
            }
        }

        boolean[] workUsed = new boolean[workers.length];
        boolean[] bikeUsed = new boolean[bikes.length];
        int[] res = new int[workers.length];

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (workUsed[now[1]] || bikeUsed[now[2]]) continue;
            res[now[1]] = now[2];
            workUsed[now[1]] = true;
            bikeUsed[now[2]] = true;
        }
        return res;
    }


}
