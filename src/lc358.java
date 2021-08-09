import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/8
 */
public class lc358 {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int n = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < 26; ++i) {
            if (count[i] != 0) {
                pq.add(new int[]{i, count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (!deque.isEmpty() && deque.peekFirst()[2] + k <= i) {
                pq.add(deque.pollFirst());
            }
            if (pq.isEmpty()) return "";
            int[] now = pq.poll();
            sb.append((char) (now[0] + 'a'));
            if (now[1] > 1)
                deque.addLast(new int[]{now[0], now[1] - 1, i});
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        lc358 test = new lc358();
        test.rearrangeString("aaabc", 3);
    }
}
