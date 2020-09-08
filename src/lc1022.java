/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc1022 {
    public int sumRootToLeaf(TreeNode root) {
        return calEveryNum(root, 0);
    }

    public int calEveryNum(TreeNode node, int father) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return father * 2 + node.val;

        int left = calEveryNum(node.left, father * 2 + node.val);
        int right = calEveryNum(node.right, father * 2 + node.val);
        return left + right;
    }
}
