/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/26
 */
public class lc328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode();
        ListNode oddTmp = odd;
        ListNode even = new ListNode();
        ListNode evenTmp = even;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                oddTmp.next = head;
                oddTmp = oddTmp.next;
            } else {
                evenTmp.next = head;
                evenTmp = evenTmp.next;
            }
            flag = !flag;
            head = head.next;
        }
        oddTmp.next = even.next;
        evenTmp.next = null;
        return odd.next;
    }
}
