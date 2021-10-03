import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/7
 */
public class lc636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[n];

        for (String str : logs) {
            String[] log = str.split(":");
            if (log[1].equals("end")) {
                Map.Entry<Integer, Integer> pop = stack.pop();
                res[pop.getKey()] += Integer.parseInt(log[2]) - pop.getValue() + 1;
                if (!stack.isEmpty()) {
                    stack.add(new AbstractMap.SimpleEntry<>(stack.pop().getKey(),
                            Integer.parseInt(log[2]) + 1));
                }
            } else {
                if (!stack.isEmpty()) {
                    Map.Entry<Integer, Integer> pop = stack.peek();
                    res[pop.getKey()] += Integer.parseInt(log[2]) - pop.getValue();
                }
                stack.add(new AbstractMap.SimpleEntry<>(Integer.valueOf(log[0]),
                        Integer.valueOf(log[2])));
            }
        }
        return res;
    }


}
