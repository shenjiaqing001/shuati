/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc919 {
    class CBTInserter {
        TreeNode[] nodes = new TreeNode[3000];
        int last = 0;

        public CBTInserter(TreeNode root) {
            build(root, 1);
        }

        public void build(TreeNode node, int index) {
            if (node == null) return;
            nodes[index] = node;
            last = Math.max(last, index);
            build(node.left, index * 2);
            build(node.right, index * 2 + 1);
        }

        public int insert(int val) {
            last += 1;
            nodes[last] = new TreeNode(val);
            if (last % 2 == 0) nodes[last / 2].left = nodes[last];
            else nodes[last / 2].right = nodes[last];
            return nodes[last / 2].val;
        }

        public TreeNode get_root() {
            return nodes[1];
        }
    }

}
