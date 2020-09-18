/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/19
 */
public class lc297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // System.out.println(makeString(root));
            return makeString(root);
        }

        public String makeString(TreeNode node) {
            StringBuilder sb = new StringBuilder();
            if (node == null) return "N";
            String left = makeString(node.left);
            String right = makeString(node.right);
            sb.append(node.val);
            sb.append(":");
            sb.append(left);
            sb.append(".");
            sb.append(right);
            return sb.toString();
        }

        int pos = 0;
        public TreeNode deserialize(String data) {
            if (data == "N") return null;
            return makeTreeNode(data.toCharArray());
        }

        public TreeNode makeTreeNode(char[] data) {
            if (data[pos] == 'N') {
                pos++;
                pos++;
                return null;
            }

            int num = 0;
            int tmp = 1;
            if (data[pos] == '-') {
                tmp = -1;
                pos++;
            }
            while (data[pos] != ':') {
                num = 10 * num + (data[pos] - '0') * tmp;
                pos++;
            }
            TreeNode node = new TreeNode(num);
            pos++;
            node.left = makeTreeNode(data);
            node.right = makeTreeNode(data);
            return node;
        }
    }
}
