import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/18
 */
public class lc1490 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public Node cloneTree(Node root) {
        if (root == null) return null;
        Node node = new Node(root.val);
        if (root.children.size() > 0) {
            for (Node child : root.children) {
                node.children.add(cloneTree(child));
            }
        }
        return node;
    }
}
