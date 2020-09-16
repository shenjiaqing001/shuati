/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/20
 */
public class lc662 {
    public int widthOfBinaryTree(TreeNode root) {
        long[][] tree = new long[3005][2];
        for (int i = 0; i < 3005; ++i) {
            tree[i][0] = -1;
            tree[i][1] = -1;
        }
        long max = 0;
        dfs(root, 0, 0, tree);

        for (int i = 0; i < 3005; ++i) {
            if (tree[i][0] == -1) break;
            max = Math.max(max, tree[i][1] - tree[i][0] + 1);
            System.out.println(tree[i][1] +" " + tree[i][0]);
        }

        return (int) max;
    }

    public void dfs(TreeNode node, int depth, long index, long[][] tree) {
        if (node == null) return;

        if (tree[depth][0] == -1) {
            tree[depth][0] = index;
            tree[depth][1] = index;
        } else {
            tree[depth][0] = Math.min(tree[depth][0], index);
            tree[depth][1] = Math.max(tree[depth][1], index);
        }

        dfs(node.left, depth + 1, 2 * index, tree);
        dfs(node.right, depth + 1, 2 * index + 1, tree);
    }
}
