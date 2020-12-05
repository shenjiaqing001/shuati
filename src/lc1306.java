import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/30
 */
public class lc1306 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (arr[now] == 0) return true;
            if (now + arr[now] < arr.length) {
                if (visited[now + arr[now]] == false) {
                    q.add(now + arr[now]);
                    visited[now + arr[now]] = true;
                }
            }
            if (now - arr[now] >= 0) {
                if (visited[now - arr[now]] == false) {
                    q.add(now - arr[now]);
                    visited[now - arr[now]] = true;
                }
            }
        }
        return false;
    }
}
