/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        ListNode now = newHead;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                now.next = null;
            } else {
                now.next = head;
                now = now.next;
                head = head.next;
            }
        }
        return newHead.next;
    }
}
