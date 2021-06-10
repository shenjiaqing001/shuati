package WeeklyContest223;


import BiWeeklyContest40.lc1669;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/5
 */
public class lc1721 {

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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode countHead = head;
        ListNode newHead = new ListNode();
        newHead.next = head;
        head = newHead;
        int count = 0;
        while (countHead != null) {
            count++;
            countHead = countHead.next;
        }
        k = Math.min(k, count + 1 - k);
        ListNode res = head;
        ListNode node1 = head;
        for (int i = 0; i < k; ++i) {
            node1 = head;
            head = head.next;
        }
        ListNode node2 = head;
        ListNode node3 = head.next;

        ListNode node4 = head;

        for (int i = 0; i < count - 2 * (k - 1) - 1; ++i) {
            node4 = head;
            head = head.next;
        }
        ListNode node5 = head;
        ListNode node6 = head.next;

        node1.next = node5;
        if (node5 != node3) {
            node5.next = node3;
            node4.next = node2;
        } else {
            node5.next = node2;
        }
        node2.next = node6;
        return res.next;
    }
}
