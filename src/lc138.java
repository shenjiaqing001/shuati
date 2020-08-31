import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/9/20
 */
public class lc138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node now = newHead;


        while (head != null) {
            Node newNode = null;
            if (map.containsKey(head))
                newNode = map.get(head);
            else {
                newNode = new Node(head.val);
                map.put(head, newNode);
            }
            now.next = newNode;
            now = now.next;

            if (head.random == null) {
                now.random = null;
            } else {
                Node rNode = null;
                if (map.containsKey(head.random)) {
                    rNode = map.get(head.random);
                } else {
                    rNode = new Node(head.random.val);
                    map.put(head.random, rNode);
                }
                now.random = rNode;
            }
            head = head.next;
        }
        return newHead.next;
    }
}
