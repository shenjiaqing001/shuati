import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/6
 */
public class lc1466 {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        List<Integer>[] inMap = new List[n];
        List<Integer>[] outMap = new List[n];
        for (int i = 0; i < n; ++i) {
            inMap[i] = new LinkedList<>();
            outMap[i] = new LinkedList<>();
        }

        for (int[] connection : connections) {
            outMap[connection[0]].add(connection[1]);
            inMap[connection[1]].add(connection[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            set.add(now);
            for (Integer out : outMap[now]) {
                if (!set.contains(out)) {
                    q.add(out);
                    res += 1;
                }
            }
            for (Integer in : inMap[now]) {
                if (!set.contains(in)) {
                    q.add(in);
                }
            }
        }

        return res;
    }
}
