/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lowHead = new ListNode();
        ListNode highHead = new ListNode();

        ListNode lowTmp = lowHead;
        ListNode highTmp = highHead;
        while (head != null) {
            if(head.val < x) {
                lowTmp.next = head;
                lowTmp = lowTmp.next;
            }
            else{
                highTmp.next = head;
                highTmp = highTmp.next;
            }
            head = head.next;
        }
        highTmp.next = null;
        lowTmp.next = highHead.next;
        return lowHead.next;
    }

}
