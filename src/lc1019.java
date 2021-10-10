import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/16
 */
public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        int now = 0;
        while (head != null) {
            while (!stack.empty() && stack.peek()[0] < head.val) {
                int[] pop = stack.pop();
                map.put(pop[1], head.val);
            }
            stack.add(new int[]{head.val, now++});
            head = head.next;
        }
        int[] tmp = new int[now];
        for (Integer key : map.keySet()) {
            tmp[key] = map.get(key);
        }
        return tmp;
    }
}
