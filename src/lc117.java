import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc117 {
    public Node connect(Node root) {
        if (root == null) return root;
        Node head = root;
        List<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node tmp = null;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                if (tmp == null)
                    tmp = queue.remove(0);
                else {
                    tmp.next = queue.remove(0);
                    tmp = tmp.next;
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null)
                    queue.add(tmp.right);
            }
        }
        return root;
    }
}
