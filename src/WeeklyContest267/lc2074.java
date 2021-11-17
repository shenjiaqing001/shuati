package WeeklyContest267;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class lc2074 {
    public void reverse(List<ListNode> nodeList, int start, int end) {
        while (start < end) {
            ListNode n1 = nodeList.get(start);
            ListNode n2 = nodeList.get(end);
            nodeList.set(start, n2);
            nodeList.set(end, n1);
            start++;
            end--;
        }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        int count = 0;
        int index = 1;
        // 2 : 1-2
        // 4 : 6-9
        while (count < nodeList.size()) {
            count += index;
            int startIndex = (index - 1) * index / 2;
            int endIndex = (index) * (index + 1) / 2 - 1;
            if (endIndex >= nodeList.size()) {
                endIndex = nodeList.size() - 1;
                if ((endIndex - startIndex + 1) % 2 == 0) {
                    reverse(nodeList, startIndex, Math.min(endIndex, nodeList.size() - 1));
                }
            } else {
                if (index % 2 == 0) {
                    reverse(nodeList, startIndex, Math.min(endIndex, nodeList.size() - 1));
                }
            }
            index++;
        }

        ListNode tmpHead = new ListNode();
        ListNode tmp = tmpHead;
        for (ListNode node : nodeList) {
            tmp.next = node;
            tmp = tmp.next;
            tmp.next = null;
        }
        return tmpHead.next;
    }

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
}
