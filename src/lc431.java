import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/30
 */
public class lc431 {

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

    class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) return null;
            TreeNode node = new TreeNode(root.val);
            node.left = dfsEncode(root.children);
            return node;
        }

        public TreeNode dfsEncode(List<Node> children) {
            if (children.size() == 0) return null;
            TreeNode root = new TreeNode();
            TreeNode tmp = root;
            for (int i = 0; i < children.size(); ++i) {
                tmp.right = new TreeNode(children.get(i).val);
                tmp = tmp.right;
                tmp.left = dfsEncode(children.get(i).children);
            }
            return root.right;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) return null;
            Node node = new Node(root.val, new LinkedList<Node>());
            if(root.left != null){
                node.children = dfsDecode(root.left);
            }
            return node;
        }

        public List<Node> dfsDecode(TreeNode root) {
            List<Node> children = new LinkedList<>();
            if (root == null) return children;

            while (root != null) {
                Node child = new Node(root.val, new LinkedList<Node>());
                child.children = dfsDecode(root.left);
                children.add(child);
                root = root.right;
            }
            return children;
        }
    }


}
