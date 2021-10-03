import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/27
 */
public class lc1751 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (o1, o2) -> (o1[1] - o2[1]));
        int n = events.length;
        TreeMap<Integer, int[]> map = new TreeMap<>();
        map.put(0, new int[k + 1]);
        for (int[] event : events) {
            if (!map.containsKey(event[1])) {
                int[] last = map.get(map.floorKey(event[1]));
                int[] now = new int[k + 1];
                for (int i = 0; i <= k; ++i) {
                    now[i] = last[i];
                }
                map.put(event[1], now);
            }
            int[] pre = map.get(map.floorKey(event[0] - 1));
            int[] next = map.get(event[1]);
            for (int i = 1; i <= k; ++i) {
                next[i] = Math.max(next[i], pre[i - 1] + event[2]);
            }
        }
        int max = 0;
        int[] last = map.get(events[n - 1][1]);
        for (int i = 1; i <= k; ++i) {
            max = Math.max(last[i], max);
        }
        return max;
    }
}
