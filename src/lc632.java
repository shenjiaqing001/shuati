import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/26
 */
public class lc632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        int max = -100000;
        int[] res = new int[3];
        for (int i = 0; i < nums.size(); ++i) {
            int num = nums.get(i).get(0);
            max = Math.max(max, num);
            pq.add(new int[]{num, i, 0});
        }
        res[0] = pq.peek()[0];
        res[1] = max;
        while (true) {
            int[] first = pq.poll();
            int next = first[2] + 1;
            if (next == nums.get(first[1]).size()) break;
            int num = nums.get(first[1]).get(next);
            max = Math.max(max, num);
            pq.add(new int[]{num, first[1], next});
            if (res[1] - res[0] > max - pq.peek()[0]) {
                res[0] = pq.peek()[0];
                res[1] = max;
            }
        }
        return res;
    }
}
