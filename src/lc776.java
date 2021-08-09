import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/14
 */
public class lc776 {
    List<Integer> largeList = new LinkedList<>();
    List<Integer> smallList = new LinkedList<>();

    public TreeNode[] splitBST(TreeNode root, int target) {
        dfs(root, target);

        TreeNode big = null;
        if (largeList.size() > 0) {
            big = new TreeNode(largeList.remove(0));
            for (Integer num : largeList) {
                buildBST(big, num);
            }
        }

        TreeNode small = null;
        if (smallList.size() > 0) {
            small = new TreeNode(smallList.remove(0));
            for (Integer num : smallList) {
                buildBST(small, num);
            }
        }

        return new TreeNode[]{big, small};
    }


    public void buildBST(TreeNode root, Integer num) {
        if (num < root.val) {
            if (root.left == null) root.left = new TreeNode(num);
            else buildBST(root.left, num);
        } else {
            if (root.right == null) root.right = new TreeNode(num);
            else buildBST(root.right, num);
        }
    }


    public void dfs(TreeNode root, int target) {
        if (root == null) return;

        if (root.val > target) largeList.add(root.val);
        else smallList.add(root.val);

        dfs(root.left, target);
        dfs(root.right, target);
    }

    public static void t(TreeNode root) {
        root = new TreeNode(5);
    }

    public static void main(String[] args) {
        lc776 test = new lc776();
        TreeNode node = new TreeNode();
        t(node);
        System.out.println(node.val);

    }
}
