/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/28/21
 */
public class lc876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
