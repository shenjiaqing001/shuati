/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/15
 */
public class lc1522 {
    int max = 0;

    public int dfs(Node root) {
        if (root == null) return 0;
        int max1 = 0;
        int max2 = 0;
        for (Node child : root.children) {
            int depth = dfs(child);
            if (depth >= max1) {
                max2 = max1;
                max1 = depth;
            } else if (depth >= max2) {
                max2 = depth;
            }
        }
        max = Math.max(max, max1 + max2);
        return max1 + 1;
    }

    public int diameter(Node root) {
        dfs(root);
        return max;
    }
}
