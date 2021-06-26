import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/24
 */
public class lc863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        distanceK(res, root, target, K, -1);
        return res;
    }

    public int distanceK(List<Integer> res, TreeNode root, TreeNode target, int K, int left) {
        if (root == null) return -1;
        if (left >= 0) {
            if (left == 0) {
                res.add(root.val);
                return 0;
            } else {
                distanceK(res, root.left, target, K, left - 1);
                distanceK(res, root.right, target, K, left - 1);
                return 0;
            }
        } else {
            if (root == target) {
                if (K == 0) {
                    res.add(root.val);
                    return -1;
                } else {
                    distanceK(res, root.left, target, K, K - 1);
                    distanceK(res, root.right, target, K, K - 1);
                    return 0;
                }
            }

            int l = distanceK(res, root.left, target, K, left);
            int r = distanceK(res, root.right, target, K, left);
            if (l == -1 && r == -1) return -1;
            if (l != -1) {
                if (l == K - 1) {
                    res.add(root.val);
                    return -1;
                } else {
                    distanceK(res, root.right, target, K, K - l - 2);
                }
                return l + 1;
            } else {
                if (r == K - 1) {
                    res.add(root.val);
                    return -1;
                } else {
                    distanceK(res, root.left, target, K, K - r - 2);
                }
                return r + 1;
            }
        }
    }
}
