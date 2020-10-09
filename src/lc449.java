/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            dfs(sb, root);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public void dfs(StringBuilder sb, TreeNode root) {
            if (root == null) return;
            sb.append(root.val).append(",");
            dfs(sb, root.left);
            dfs(sb, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            String[] nums = data.split(",");
            TreeNode root = new TreeNode(Integer.valueOf(nums[0]));
            for (int i = 1; i < nums.length; ++i) {
                bst(root, Integer.valueOf(nums[i]));
            }
            return root;
        }

        public void bst(TreeNode root, int num) {
            while (true) {
                if (root.val < num) {
                    if (root.right == null) {
                        root.right = new TreeNode(num);
                        break;
                    } else root = root.right;
                } else {
                    if (root.left == null) {
                        root.left = new TreeNode(num);
                        break;
                    } else root = root.left;
                }
            }
        }
    }
}
