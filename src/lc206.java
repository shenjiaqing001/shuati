/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode tmp = newHead;
        while (head != null) {
            ListNode now = head;
            head = head.next;
            now.next = tmp.next;
            tmp.next = now;
        }
        return newHead.next;
    }
}
