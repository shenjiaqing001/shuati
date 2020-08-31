/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return makeTreeNode(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode makeTreeNode(int[] preorder, int plow, int phigh,
                                 int[] inorder, int ilow, int ihigh) {
        if (plow > phigh) return null;
        if (plow == phigh) return new TreeNode(preorder[plow]);

        TreeNode now = new TreeNode(preorder[plow]);

        int position = ilow;
        for (int i = ilow; i <= ihigh; ++i) {
            if (inorder[i] == preorder[plow])
                position = i;
        }
        now.left = makeTreeNode(preorder, plow + 1, plow + position - ilow,
                inorder, ilow, position - 1);
        now.right =
                makeTreeNode(preorder, plow + 2 + (position - 1 - ilow), phigh,
                        inorder, position + 1, ihigh);
        return now;
    }
}
