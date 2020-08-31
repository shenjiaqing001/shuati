/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */
public class lc141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast.next == null)
                return false;
            fast = fast.next;
            if (fast == slow)
                return true;
            if (fast.next == null)
                return false;
            fast = fast.next;
            if (fast == slow)
                return true;
            slow = slow.next;
        }
    }
}
