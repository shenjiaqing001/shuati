import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/27
 */
public class lc331 {
    public static void main(String[] args) {
        lc331 test = new lc331();
        test.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#");
    }

    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        if (strs.length == 1 && strs[0].equals("#")) return true;
        Deque<Integer> stack = new ArrayDeque<>();
        boolean flag = false;
        for (String str : strs) {
            if (str.equals("#")) {
                if (stack.isEmpty()) return false;
                while (true) {
                    if (stack.isEmpty()) break;
                    int top = stack.pollLast();
                    if (top == 0) {
                        stack.add(1);
                        break;
                    }
                }
            } else {
                if (stack.isEmpty() && flag) return false;
                stack.add(0);
                flag = true;
            }
        }
        return stack.isEmpty();
    }
}
