import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/27
 */
public class lc501 {
    List<Integer> list = new ArrayList<>();
    int prev = -100000;
    int count = 0;
    int max = 0;

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (root.val == prev) {
            count++;
        } else {
            prev = root.val;
            count = 1;
        }
        if (count > max) {
            max = count;
            list = new ArrayList<>();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }

        dfs(root.right);
    }


    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] res = new int[list.size()];
        int index = 0;
        for (int num : list) {
            res[index++] = num;
        }
        return res;
    }
}
