/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/13
 */
public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode now = new ListNode();
        ListNode head = now;
        int left = 0;
        while (l1 != null || l2 != null || left != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += left;
            left = sum / 10;
            sum %= 10;
            now.next = new ListNode(sum);
            now = now.next;
        }
        return head.next;
    }
}
