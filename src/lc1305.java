import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        traverse(list1, root1);
        traverse(list2, root2);
        List<Integer> res = new LinkedList<>();
        while (list1.size() > 0 && list2.size() > 0) {
            int num1 = list1.get(0);
            int num2 = list2.get(0);
            if (num1 > num2) res.add(list2.remove(0));
            else res.add(list1.remove(0));
        }
        while (list1.size() > 0) res.add(list1.remove(0));
        while (list2.size() > 0) res.add(list2.remove(0));
        return res;
    }

    public void traverse(List<Integer> res, TreeNode root) {
        if (root == null) return;
        traverse(res, root.left);
        res.add(root.val);
        traverse(res, root.right);
    }
}
