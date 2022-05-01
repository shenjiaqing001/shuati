import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/27/22
 */
public class lc1166 {
    class FileSystem {

        class TreeNode {
            int val;
            String path;
            Set<TreeNode> children;

            TreeNode() {
            }

            TreeNode(int val, String path) {
                this.val = val;
                this.path = path;
                this.children = new HashSet<>();
            }
        }

        TreeNode root = new TreeNode();

        public FileSystem() {
            root.children = new HashSet<>();
        }

        public boolean createPath(String path, int value) {
            String[] dicts = path.split("/");
            TreeNode tmp = root;
            int index = 1;
            while (index != dicts.length) {
                boolean flag = false;
                for (TreeNode child : tmp.children) {
                    if (child.path.equals(dicts[index])) {
                        if (index == dicts.length - 1) return false;
                        index++;
                        tmp = child;
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
            for (TreeNode child : tmp.children) {
                if (child.path.equals(dicts[index])) {
                    return false;
                }
            }
            tmp.children.add(new TreeNode(value, dicts[index]));
            return true;
        }

        public int get(String path) {
            String[] dicts = path.split("/");
            TreeNode tmp = root;
            int index = 1;
            while (index != dicts.length) {
                boolean flag = false;
                for (TreeNode child : tmp.children) {
                    if (child.path.equals(dicts[index])) {
                        index++;
                        tmp = child;
                        flag = true;
                        break;
                    }
                }
                if (!flag) return -1;
            }
            return tmp.val;
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
}
