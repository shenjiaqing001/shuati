/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/28/20
 */
public class lc889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        return makeTreeNode(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public TreeNode makeTreeNode(int[] pre, int preLow, int preHigh,
                                 int[] post, int postLow, int postHigh) {
        if (preLow > preHigh) return null;
        if (preLow == preHigh) return new TreeNode(pre[preLow]);

        TreeNode node = new TreeNode(pre[preLow]);
        int i;
        for (i = postLow; i <= postHigh; ++i) {
            if (pre[preLow + 1] == post[i])
                break;
        }

        node.left = makeTreeNode(pre, preLow + 1, preLow + 1 + i - postLow,
                post, postLow, i);
        node.right = makeTreeNode(pre, preLow + 2 + i - postLow, preHigh,
                post, i + 1, postHigh - 1);
        return node;
    }

}
