package WeeklyContest204;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc4 {
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

    public void dfs(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }

    public int numOfWays(int[] nums) {
        TreeNode root = null;
        for (int i = 0; i < nums.length; ++i) {
            root = makeNode(root, nums[i]);
        }

        int n = nums.length;
        long[][] dp = new long[n + 1][n + 1];

        for (int i = 0; i <= n; ++i) dp[i][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (i + j > n + 1) {
                    break;
                }
                if (i == j) {
                    dp[i][j] = 2 * dp[i][j - 1];
                } else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= 1000000007;
            }
        }
        return (int) (count(root, dp)[1]) - 1;
    }

    public TreeNode makeNode(TreeNode root, int num) {
        if (root == null) {
            root = new TreeNode(num);
            return root;
        }
        if (root.val > num)
            root.left = makeNode(root.left, num);
        else
            root.right = makeNode(root.right, num);
        return root;
    }

    public long[] count(TreeNode root, long[][] dp) {
        if (root == null) {
            return new long[]{0, 1};
        }

        long[] left = count(root.left, dp);
        long[] right = count(root.right, dp);
        long num;
        long count;
        num = left[0] + right[0] + 1;

        count = Math.max(dp[(int) left[0]][(int) right[0]], dp[(int) right[0]][(int) left[0]]);
        count = ((count * left[1]) % 1000000007) * right[1] % 1000000007;
        return new long[]{num, count};
    }

    public static void main(String[] args) {
        lc4 t = new lc4();
        System.out.println(t.numOfWays(
                new int[]{10, 23, 12, 18, 4, 29, 2, 8, 41, 31, 25, 21, 14, 35, 26, 5, 19, 43, 22, 37, 9, 20, 44, 28, 1, 39, 30, 38, 36, 6, 13, 16, 27, 17, 34, 7, 15, 3, 11, 24, 42, 33, 40, 32}));
    }

}
