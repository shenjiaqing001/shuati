import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/29/22
 */
public class lc1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) queue.add(stone);
        while (queue.size() > 1) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            if (n1 != n2) {
                queue.add(n1 - n2);
            }
        }
        if (queue.isEmpty()) return 0;
        return queue.poll();
    }
}
