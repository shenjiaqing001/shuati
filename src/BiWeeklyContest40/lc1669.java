package BiWeeklyContest40;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/29
 */
public class lc1669 {
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode left = list1;
        for (int i = 0; i < a - 1; ++i) {
            left = left.next;
        }
        ListNode right = left;
        for (int i = 0; i <= b - a; ++i) {
            right = right.next;
        }
        left.next = list2;
        while (list2.next != null) list2 = list2.next;
        list2.next = right.next;
        return head;
    }
}
