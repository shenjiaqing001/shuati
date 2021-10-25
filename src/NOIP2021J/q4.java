package NOIP2021J;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/24
 */
public class q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StringBuilder> res = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        for (int i = 1; i <= n; ++i) {
            int next = sc.nextInt();
            if (stack.isEmpty()) {
                res.add(new StringBuilder().append(i));
                stack.add(new int[]{next, 1});
                continue;
            }
            int[] last = stack.peek();
            int num = 0;
            if (last[0] == next) {
                stack.pop();
                last[1] += 1;
                int max = 0;
                while (true) {
                    if (stack.isEmpty()) {
                        num = last[1] - 1;
                        stack.add(last);
                        break;
                    }
                    int[] block = stack.peek();
                    if (block[0] == next) {
                        block[1] += last[1] - max;
                        stack.pop();
                        last = block;
                        max = 0;
                    } else {
                        if (block[1] >= last[1]) {
                            num = last[1] - 1;
                            stack.add(last);
                            break;
                        } else {
                            max = Math.max(max, block[1]);
                            stack.pop();
                        }
                    }
                }
            } else {
                stack.add(new int[]{next, 1});
            }
            if (res.size() <= num) {
                res.add(new StringBuilder().append(i));
            } else {
                res.get(num).append(" ").append(i);
            }
        }
        for (StringBuilder s : res) {
            System.out.println(s.toString());
        }
    }
}
