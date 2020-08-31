import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rightHead = new ListNode();
        ListNode now = slow.next;
        slow.next = null;

        while (now != null) {
            ListNode tmp = rightHead.next;
            rightHead.next = now;
            now = now.next;
            rightHead.next.next = tmp;
        }

        rightHead = rightHead.next;
        while (rightHead != null) {
            if (rightHead.val != head.val) return false;
            rightHead = rightHead.next;
            head = head.next;
        }
        return true;
    }
}
