/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return makeTreeNode(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    public TreeNode makeTreeNode(int[] postorder, int plow, int phigh,
                                 int[] inorder, int ilow, int ihigh) {
        if (plow > phigh) return null;
        if (plow == phigh) return new TreeNode(postorder[plow]);

        TreeNode now = new TreeNode(postorder[phigh]);

        int position = ilow;
        for (int i = ilow; i <= ihigh; ++i) {
            if (inorder[i] == postorder[phigh])
                position = i;
        }
        now.left = makeTreeNode(postorder, plow, plow + position - ilow -1 ,
                inorder, ilow, position - 1);
        now.right =
                makeTreeNode(postorder, plow + position - ilow, phigh-1,
                        inorder, position + 1, ihigh);
        return now;
    }
}
