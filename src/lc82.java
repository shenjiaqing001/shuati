/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        int last = head.val;
        boolean flag = true;
        ListNode tmp = new ListNode();
        ListNode newHead = tmp;

        while (head.next != null) {
            if (head.next.val == last) {
                flag = false;
                head = head.next;
            } else {
                if (flag == false) {
                    head = head.next;
                    last = head.val;
                    flag = true;
                } else {
                    tmp.next = new ListNode(last);
                    tmp = tmp.next;
                    head = head.next;
                    last = head.val;
                }
            }
        }
        if (flag == true)
            tmp.next = new ListNode(last);

        return newHead.next;
    }


}
