import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode();
        ListNode now = head;

        for (ListNode listNode : lists) {
            if (listNode != null)
                pq.add(listNode);
        }

        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            now.next = tmp;
            now = now.next;
            if (tmp.next != null) {
                pq.add(tmp.next);
            }
        }

        return head.next;
    }

    public List<Integer> mergeKLists2(ListNode[] lists, int k) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        List<Integer> res = new ArrayList<>();

        for (ListNode listNode : lists) {
            if (listNode != null)
                pq.add(listNode);
        }

        while (!pq.isEmpty()) {
            int num = pq.peek().val;
            int count = 0;
            while (!pq.isEmpty() && pq.peek().val == num) {
                ListNode tmp = pq.poll();
                count++;
                while (tmp != null && tmp.val == num) {
                    tmp = tmp.next;
                }
                if (tmp != null) {
                    pq.add(tmp);
                }
            }
            if (count >= k) res.add(num);
        }
        return res;
    }
}
