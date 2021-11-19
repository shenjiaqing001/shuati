import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/2
 */
public class lc430 {


    public Node flatten(Node head) {
        if (head == null) return null;
        Node fakeHead = new Node();
        Node now = fakeHead;
        Stack<Node> stack = new Stack<>();
        Node tmp = head;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp == null) tmp = stack.pop();
            now.next = tmp;
            if (tmp.child != null) {
                if (tmp.next != null) stack.add(tmp.next);
                tmp = tmp.child;
            } else {
                tmp = tmp.next;
            }
            now.child = null;
            now.next.prev = now;
            now = now.next;
        }
        fakeHead.next.prev = null;
        return fakeHead.next;
    }
}
