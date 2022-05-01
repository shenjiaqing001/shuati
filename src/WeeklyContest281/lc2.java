package WeeklyContest281;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/19/22
 */
public class lc2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode fakeHead = new ListNode();
        ListNode cur = fakeHead;
        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                cur.next = new ListNode(sum);
                cur = cur.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return fakeHead.next;
    }
}
