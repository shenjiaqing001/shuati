import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node prev;
    public Node next;
    public Node parent;
    public Node child;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}
