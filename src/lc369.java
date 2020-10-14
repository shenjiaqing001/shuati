/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/14
 */
public class lc369 {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode it = newHead;
        ListNode lastNotNine = newHead;
        while (it.next != null) {
            if (it.next.val != 9) {
                lastNotNine = it.next;
            }
            it = it.next;
        }

        if (lastNotNine == newHead) {
            newHead.val = 1;
            while (lastNotNine.next != null) {
                lastNotNine = lastNotNine.next;
                lastNotNine.val = 0;
            }
            return newHead;
        } else {
            lastNotNine.val = lastNotNine.val + 1;
            while (lastNotNine.next != null) {
                lastNotNine = lastNotNine.next;
                lastNotNine.val = 0;
            }
            return newHead.next;
        }
    }
}
