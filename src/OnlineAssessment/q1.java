package OnlineAssessment;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/29
 */
public class q1 {

    public ListNode deleteListNode(ListNode head) {
        boolean flag = false;
        ListNode tmp = head;
        while (true) {
            if (tmp.next == null || tmp.next.next == null) {
                tmp.next = null;
                break;
            }
            tmp.next = tmp.next.next;
            tmp = tmp.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
