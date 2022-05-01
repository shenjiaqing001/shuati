import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/15/22
 */
public class lc1586 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class BSTIterator {

        List<Integer> list = new ArrayList<>();
        int index = -1;

        public BSTIterator(TreeNode root) {
            inorder(root);
        }

        private void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        public boolean hasNext() {
            return index < list.size() - 1;
        }

        public int next() {
            index++;
            return list.get(index);
        }

        public boolean hasPrev() {
            return index > 0 && list.size() > 1;
        }

        public int prev() {
            index--;
            return list.get(index);
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
}
