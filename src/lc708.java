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
        if (head.next == head) {
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }

        Node now = head;
        while (true) {
            Node next = now.next;
            if (now.val > next.val) {
                if (insertVal >= now.val || insertVal <= next.val) {
                    Node tmp = new Node(insertVal);
                    tmp.next = next;
                    now.next = tmp;
                    return head;
                }
            } else {
                if (insertVal >= now.val && insertVal <= next.val) {
                    Node tmp = new Node(insertVal);
                    tmp.next = next;
                    now.next = tmp;
                    return head;
                }
            }
            now = now.next;
            if (now == head) {
                Node tmp = new Node(insertVal);
                tmp.next = next;
                now.next = tmp;
                return head;
            }
        }
    }
}
