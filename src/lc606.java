/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/26
 */
public class lc606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, t);
        return sb.toString();
    }

    public void dfs(StringBuilder sb, TreeNode root) {
        if (root == null) return;

        sb.append(root.val);
        if (root.left != null) {
            sb.append('(');
            dfs(sb, root.left);
            sb.append(')');
            if (root.right != null) {
                sb.append('(');
                dfs(sb, root.right);
                sb.append(')');
            }
        } else {
            if (root.right != null) {
                sb.append("()");
                sb.append('(');
                dfs(sb, root.right);
                sb.append(')');
            } else {
                return;
            }
        }
    }
}
