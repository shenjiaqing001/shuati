import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/30
 */
public class lc655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int height = getHeight(root);
        int width = (int) (Math.pow(2, height) - 1);

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (res.size() < i + 1) res.add(new ArrayList<>());
                res.get(i).add("");
            }
        }
        makeTree(res, root, 0, 0, width - 1);
        return res;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public void makeTree(List<List<String>> res, TreeNode root, int level, int left, int right) {
        if (root == null) return;
        res.get(level).set((left + right) / 2, String.valueOf(root.val));
        makeTree(res, root.left, level + 1, left, (left + right) / 2 - 1);
        makeTree(res, root.right, level + 1, (left + right) / 2 + 1, right);
    }
}
