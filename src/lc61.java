/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/20/20
 */
public class lc61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        int count = 1;
        ListNode back = head;
        while (back.next != null) {
            count++;
            back = back.next;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        k = count - k;

        ListNode res = head;
        back.next = head;
        while (k > 1) {
            res = res.next;
            k--;
        }
        ListNode tmp = res;
        tmp = tmp.next;
        res.next = null;
        return tmp;
    }


}
