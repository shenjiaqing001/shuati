/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        int last = head.val;
        ListNode tmp = new ListNode();
        ListNode newHead = tmp;

        while (head.next != null) {
            if (head.next.val == last) {
                head = head.next;
            } else {

                tmp.next = new ListNode(last);
                tmp = tmp.next;
                head = head.next;
                last = head.val;
            }
        }

        tmp.next = new ListNode(last);

        return newHead.next;
    }
}
