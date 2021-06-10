import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/21
 */
public class lc241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        int last = 0;
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                nums.add(last);
                last = 0;
            } else {
                last = 10 * last + (c - '0');
            }
        }
        nums.add(last);
        int n = ops.size();
        return dfs(nums, ops, 0, n);
    }

    public List<Integer> dfs(List<Integer> nums, List<Character> ops, int left, int right) {
        List<Integer> res = new ArrayList<>();

        if (left == right) {
            res.add(nums.get(left));
            return res;
        }

        for (int i = left; i < right; ++i) {
            List<Integer> l = new ArrayList<>();
            List<Integer> r = new ArrayList<>();

            l = dfs(nums, ops, left, i);
            r = dfs(nums, ops, i + 1, right);

            for (Integer n1 : l) {
                for (Integer n2 : r) {
                    if (ops.get(i) == '+') res.add(n1 + n2);
                    if (ops.get(i) == '-') res.add(n1 - n2);
                    if (ops.get(i) == '*') res.add(n1 * n2);
                }
            }
        }
        return res;
    }


}
