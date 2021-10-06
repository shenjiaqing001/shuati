import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/21
 */
public class lc735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; ++i) {
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0 &&
                    stack.peek() < -asteroids[i]) {
                stack.pop();
            }


            if (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0) stack.add(asteroids[i]);
            else if (stack.peek() == -asteroids[i]) stack.pop();
        }
        if (stack.size() == 0) return new int[]{};
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return res;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == -asteroid) stack.pop();
                else {
                    if (stack.isEmpty() || stack.peek() < 0) stack.add(asteroid);
                }
            } else {
                stack.add(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return res;
    }

}
