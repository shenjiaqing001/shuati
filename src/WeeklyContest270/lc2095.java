package WeeklyContest270;

import OnlineAssessment.q1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/4/21
 */
public class lc2095 {
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

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode tmpHead = new ListNode();
        ListNode now = tmpHead;
        for (int i = 0; i < list.size(); ++i) {
            if (i == list.size() / 2) {
                continue;
            } else {
                now.next = list.get(i);
                now = now.next;
                now.next = null;
            }
        }
        return tmpHead.next;
    }
}
