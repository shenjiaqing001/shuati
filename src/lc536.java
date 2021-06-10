/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/21
 */
public class lc536 {
    int pos = 0;

    public TreeNode str2tree(String s) {
        if (pos == s.length()) return null;
        if (s.equals("")) return null;
        if (s.charAt(pos) == ')') return null;
        if (s.charAt(pos) == '(') pos++;

        int positive = 1;
        if (s.charAt(pos) == '-') {
            positive = -1;
            pos++;
        }
        int num = 0;
        while (pos < s.length() && s.charAt(pos) != '(' && s.charAt(pos) != ')') {
            num = num * 10 + (s.charAt(pos) - '0');
            pos++;
        }
        num *= positive;
        TreeNode now = new TreeNode(num);
        if (pos == s.length()) return now;

        if (s.charAt(pos) == ')') {
            pos++;
            return now;
        } else {
            pos++;
            now.left = str2tree(s);
            now.right = str2tree(s);
            pos++;
            return now;
        }
    }

    public static void main(String[] args) {
        lc536 t = new lc536();
        t.str2tree("4(2(3)(1))(6(5))");
        System.out.println();
    }
}
