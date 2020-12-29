import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/27
 */
public class lc1345 {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        boolean[] flag = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            map.putIfAbsent(arr[i], new LinkedList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        flag[0] = true;
        int step = 0;
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int now = q.poll();
                if (now == n - 1) return step;
                if (!set.contains(arr[now])) {
                    for (Integer pos : map.get(arr[now])) {
                        if (pos != now) q.add(pos);
                        flag[pos] = true;
                    }
                    set.add(arr[now]);
                }
                if (now > 0) {
                    if (flag[now - 1] == false) {
                        q.add(now - 1);
                        flag[now - 1] = true;
                    }
                }
                if (now < n - 1) {
                    if (flag[now + 1] == false) {
                        q.add(now + 1);
                        flag[now + 1] = true;
                    }
                }
            }
            step++;
        }
    }
}
