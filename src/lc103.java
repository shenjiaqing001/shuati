import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/27/20
 */
public class lc103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<TreeNode> last = new ArrayList<>();
        last.add(root);
        boolean flag = true;
        while (!last.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            if (flag == true) {
                for (int i = 0; i < last.size(); ++i) {
                    level.add(last.get(i).val);
                }
            } else {
                for (int i = last.size() - 1; i >= 0; --i) {
                    level.add(last.get(i).val);
                }
            }

            for (int i = 0;i<last.size();++i){
                if (last.get(i).left != null) tmp.add(last.get(i).left);
                if (last.get(i).right != null) tmp.add(last.get(i).right);
            }

            flag = !flag;
            res.add(level);
            last = tmp;
        }
        return res;
    }
}
