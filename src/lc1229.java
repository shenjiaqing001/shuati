import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < slots1.length; ++i) {
            if (slots1[i][1] - slots1[i][0] >= duration)
                pq.add(slots1[i]);
        }

        for (int i = 0; i < slots2.length; ++i) {
            if (slots2[i][1] - slots2[i][0] >= duration)
                pq.add(slots2[i]);
        }

        while (pq.size() > 1) {
            int[] one = pq.poll();
            int[] two = pq.peek();
            if (one[1] - two[0] >= duration)
                return Arrays.asList(new Integer[]{two[0], two[0] + duration});
        }
        return new ArrayList<>();
    }
}
