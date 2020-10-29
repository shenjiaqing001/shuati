import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/30
 */
public class lc637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfs(sum, count, root, 0);
        for (int i = 0; i < sum.size(); ++i) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    public void dfs(List<Double> sum, List<Integer> count, TreeNode root, int level) {
        if (root == null) return;
        if (sum.size() < level + 1) {
            sum.add(0.0);
            count.add(0);
        }
        sum.set(level, sum.get(level) + root.val);
        count.set(level, count.get(level) + 1);
        dfs(sum, count, root.left, level + 1);
        dfs(sum, count, root.right, level + 1);
    }
}
