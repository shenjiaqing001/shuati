import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/16
 */
public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int now = 0;
        while (head != null) {
            while (!stack.empty() && stack.peek()[0] < head.val) {
                int[] pop = stack.pop();
                res.set(pop[1], head.val);
            }
            res.add(0);
            stack.add(new int[]{head.val, now++});
            head = head.next;
        }
        int[] tmp = new int[res.size()];
        for (int i = 0; i < tmp.length; ++i) tmp[i] = res.get(i);
        return tmp;
    }
}
