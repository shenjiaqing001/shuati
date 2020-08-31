/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/10/20
 */


public class lc143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode left = head;
        ListNode right = head;

        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode mid = new ListNode();
        ListNode rightHead = left.next;
        left.next = null;
        while (rightHead != null) {
            ListNode tmp = mid.next;
            mid.next = rightHead;
            rightHead = rightHead.next;
            mid.next.next = tmp;
        }

        rightHead = mid.next;

        ListNode leftHead = head;
        while (leftHead != null && rightHead != null) {
            ListNode tmpLeft = leftHead;
            ListNode tmpRight = rightHead;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
            tmpLeft.next = tmpRight;
            tmpRight.next = leftHead;
        }
    }
}
