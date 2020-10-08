import javafx.util.Pair;

import java.util.List;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/7
 */
public class lc636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[n];
        int time = 0;

        for (String str : logs) {
            String[] log = str.split(":");
            if (log[1].equals("end")) {
                Pair<Integer, Integer> pop = stack.pop();
                res[pop.getKey()] += Integer.valueOf(log[2]) - pop.getValue() + 1;
                if (!stack.isEmpty()) {
                    stack.add(new Pair<>(stack.pop().getKey(), Integer.valueOf(log[2]) + 1));
                }
            } else {
                if (!stack.isEmpty()) {
                    Pair<Integer, Integer> pop = stack.peek();
                    res[pop.getKey()] += Integer.valueOf(log[2]) - pop.getValue();
                }
                stack.add(new Pair<>(Integer.valueOf(log[0]), Integer.valueOf(log[2])));
            }
        }
        return res;
    }


}
