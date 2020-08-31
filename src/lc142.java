/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */
public class lc142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast.next == null)
                return null;
            fast = fast.next;
            if (fast.next == null)
                return null;
            fast = fast.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
