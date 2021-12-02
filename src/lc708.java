/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/24
 */
public class lc708 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node now = head;
        while (true) {
            Node next = now.next;
            if (next == head) {
                Node tmp = new Node(insertVal);
                now.next = tmp;
                tmp.next = next;
                return head;
            }

            if (insertVal >= now.val && insertVal <= next.val) {
                Node tmp = new Node(insertVal);
                now.next = tmp;
                tmp.next = next;
                return head;
            }
            if (next.val < now.val) {
                if (insertVal >= now.val) {
                    Node tmp = new Node(insertVal);
                    now.next = tmp;
                    tmp.next = next;
                    return head;
                }
                if (insertVal <= now.val && insertVal <= next.val) {
                    Node tmp = new Node(insertVal);
                    now.next = tmp;
                    tmp.next = next;
                    return head;
                }

            }
            now = now.next;
        }
    }
}
