/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/24
 */
public class lc337 {
    public int rob(TreeNode root) {
        return robDFS(root)[1];
    }

    int[] robDFS(TreeNode node) {
        int[] res = new int[2];
        if (node == null) return res;
        int[] l = robDFS(node.left);
        int[] r = robDFS(node.right);
        res[0] = l[1] + r[1];
        res[1] = Math.max(res[0], l[0] + r[0] + node.val);
        return res;
    }
}
