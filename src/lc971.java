import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/30
 */
public class lc971 {
    List<Integer> list = new LinkedList<>();
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (!dfs(root, voyage) || index != voyage.length) {
            list = new ArrayList<>();
            list.add(-1);
            return list;
        }

        return list;
    }

    public boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) return true;
        if (root.val != voyage[index]) return false;
        index++;

        if (root.left != null && root.right != null) {
            if (root.left.val != voyage[index]) {
                list.add(root.val);
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            }
        }
        dfs(root.left, voyage);
        dfs(root.right, voyage);
        return true;
    }
}
