import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc901 {
    class StockSpanner {
        Stack<int[]> stack = new Stack<>();

        public StockSpanner() {

        }

        public int next(int price) {
            int res = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price)
                res += stack.pop()[1];
            stack.push(new int[]{price, res});
            return res;
        }
    }

}
