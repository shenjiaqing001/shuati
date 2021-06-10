import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/21
 */
public class lc590 {
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

    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        List<Node> tmp = new ArrayList<>();
        if (root == null) return res;
        tmp.add(root);
        while (!tmp.isEmpty()) {
            Node now = tmp.remove(tmp.size() - 1);
            res.add(0, now.val);
            for (int i = 0; i < now.children.size(); ++i) {
                tmp.add(now.children.get(i));
            }
        }
        return res;
    }
}
