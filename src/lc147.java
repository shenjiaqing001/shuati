/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/11/20
 */
public class lc147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode now = head.next;
        ListNode last = head;
        while (now != null) {
            if (last.val <= now.val) {
                last = now;
                now = now.next;
                continue;
            }

            last.next = now.next;
            if (now.val <= head.val) {
                now.next = head;
                head = now;
            } else {
                ListNode tmp = head;
                while (now.val > tmp.next.val) {
                    tmp = tmp.next;
                }
                now.next = tmp.next;
                tmp.next = now;
            }
            now = last.next;
        }

        return head;
    }
}
