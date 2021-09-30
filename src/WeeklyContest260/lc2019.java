package WeeklyContest260;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/25
 */
public class lc2019 {
    Set<Integer>[][] dp = new Set[32][32];

    public static void main(String[] args) {
        lc2019 test = new lc2019();
        test.scoreOfStudents("1+4+4+1*0+2", new int[]{20, 13, 42});
    }

    public int scoreOfStudents(String s, int[] answers) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (char c : s.toCharArray()) {
            if (c == '+') op = '+';
            else if (c == '*') op = '*';
            else {
                if (op == '+') stack.add(c - '0');
                else {
                    stack.add((c - '0') * stack.pop());
                }
            }
        }
        int trueRes = 0;
        while (!stack.isEmpty()) {
            trueRes += stack.pop();
        }

        Set<Integer> set = dfs(s.toCharArray(), 0, s.length() - 1);
        int sum = 0;
        for (int answer : answers) {
            if (answer == trueRes) sum += 5;
            else if (set.contains(answer)) sum += 2;
        }
        return sum;
    }

    public Set<Integer> dfs(char[] c, int left, int right) {
        if (dp[left][right] != null) return dp[left][right];
        Set<Integer> res = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (int i = left; i <= right; ++i) {
            if (c[i] == '+') {
                op = '+';
                Set<Integer> l = dfs(c, left, i - 1);
                Set<Integer> r = dfs(c, i + 1, right);
                for (int lNum : l) {
                    for (int rNum : r) {
                        if (lNum + rNum <= 1000) res.add(lNum + rNum);
                    }
                }
            } else if (c[i] == '*') {
                op = '*';
                Set<Integer> l = dfs(c, left, i - 1);
                Set<Integer> r = dfs(c, i + 1, right);
                for (int lNum : l) {
                    for (int rNum : r) {
                        if (lNum * rNum <= 1000) res.add(lNum * rNum);
                    }
                }
            } else {
                if (op == '+') stack.add(c[i] - '0');
                else {
                    stack.add((c[i] - '0') * stack.pop());
                }
            }
        }
        int trueRes = 0;
        while (!stack.isEmpty()) {
            trueRes += stack.pop();
        }
        if (trueRes <= 1000)
            res.add(trueRes);
        dp[left][right] = res;
        return res;
    }
}
