/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/24/20
 */
public class lc92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode emptyHead = new ListNode();
        if (m == 1)
            emptyHead.next = head;
        else
            emptyHead = head;
        ListNode point = emptyHead;
        for (int i = 1; i < m - 1; ++i) {
            point = point.next;
        }

        ListNode newHead = new ListNode();
        ListNode tmpPoint1 = point;
        point = point.next;
        ListNode tmpPoint2 = point;

        for (int i = m; i <= n; ++i) {
            ListNode tmp = point;
            point = point.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        tmpPoint1.next = newHead;
        tmpPoint2.next = point;

        if (m == 1)
            return emptyHead.next;
        else
            return head;
    }
}
