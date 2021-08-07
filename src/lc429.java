import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/6
 */
public class lc429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return null;
        List<List<Integer>> res = new LinkedList<>();
        List<Node> level = new LinkedList<>();
        level.add(root);
        while (level.size() > 0) {
            List<Integer> tmp = new LinkedList<>();
            List<Node> nextLevel = new LinkedList<>();
            for (Node node : level) {
                tmp.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (Node child : node.children) nextLevel.add(child);
                }
            }
            res.add(tmp);
            level = nextLevel;
        }
        return res;
    }
}
