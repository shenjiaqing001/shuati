/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/17/20
 */
public class lc173 {

    class BSTIterator {
        TreeNode root = null;

        public BSTIterator(TreeNode root) {
            this.root = root;
            toLeftMost();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int num = root.val;
            root = root.right;
            TreeNode tmp = root;
            if (tmp == null)
                return num;
            if (tmp.left != null) {
                if (tmp.left.val > num)
                    toLeftMost();
            }
            return num;
        }

        public void toLeftMost() {
            while (root.left != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = root;
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return root == null ? false : true;
        }
    }
}
