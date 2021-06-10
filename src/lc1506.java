import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/13
 */
public class lc1506 {
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

    public Node findRoot(List<Node> tree) {
        if (tree == null || tree.size() == 0) return null;
        long sum = 0;

        for (Node node : tree) {
            sum += node.val;
            for (Node child : node.children)
                sum -= child.val;
        }
        for (Node node : tree) {
            if (node.val == sum) return node;
        }
        return null;
    }
}
