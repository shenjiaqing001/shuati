/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/11/20
 */
public class lc148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = new ListNode();
        ListNode now = newHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                now.next = left;
                left = left.next;
            } else {
                now.next = right;
                right = right.next;
            }
            now = now.next;
        }

        while (left != null) {
            now.next = left;
            left = left.next;
            now = now.next;
        }
        while (right != null) {
            now.next = right;
            right = right.next;
            now = now.next;
        }
        return newHead.next;
    }
}
