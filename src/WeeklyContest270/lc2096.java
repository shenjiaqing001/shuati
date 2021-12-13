package WeeklyContest270;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/4/21
 */
public class lc2096 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sPath = new StringBuilder();
        StringBuilder dPath = new StringBuilder();
        dfs(root, startValue, sPath);
        dfs(root, destValue, dPath);
        while (sPath.length() > 0 && dPath.length() > 0 && sPath.charAt(0) == dPath.charAt(0)) {
            sPath.deleteCharAt(0);
            dPath.deleteCharAt(0);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sPath.length(); ++i) res.append("U");
        res.append(dPath);
        return res.toString();
    }

    public boolean dfs(TreeNode root, int val, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        sb.append("L");
        if (dfs(root.left, val, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("R");
        if (dfs(root.right, val, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
}
