import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
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
}
