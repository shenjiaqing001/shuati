package WeeklyContest321;

import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/26/22
 */
public class lc3 {
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

    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek() < head.val) {
                stack.pop();
            }
            stack.add(head.val);
            head = head.next;
        }
        ListNode last = new ListNode(stack.pop());
        last.next = null;
        while (!stack.isEmpty()) {
            ListNode tmp = new ListNode(stack.pop());
            tmp.next = last;
            last = tmp;
        }
        return last;
    }
/*
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }
            stack.add(head);
            head = head.next;
        }
        ListNode last = stack.pop();
        last.next = null;
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            tmp.next = last;
            last = tmp;
        }
        return last;
    }
 */
}
