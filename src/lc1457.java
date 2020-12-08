/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/8
 */
public class lc1457 {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] num = new int[10];
        return dfs(root, num);
    }

    public int dfs(TreeNode root, int[] num) {
        if (root.left == null && root.right == null) {
            num[root.val]++;
            int count = 0;
            for (int i = 1; i <= 9; ++i) {
                if (num[i] % 2 == 1) count++;
            }
            num[root.val]--;
            return count > 1 ? 0 : 1;
        }
        num[root.val]++;
        int res = 0;
        if (root.left == null) {
            res = dfs(root.right, num);
        } else if (root.right == null) {
            res = dfs(root.left, num);
        } else {
            res = dfs(root.left, num) + dfs(root.right, num);
        }
        num[root.val]--;
        return res;
    }
}
