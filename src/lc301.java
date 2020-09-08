import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                left++;
            else if(c == ')'){
                if (left == 0)
                    right++;
                else
                    left--;
            }
        }
        System.out.println(left + " " + right);
        helper(s, new StringBuilder(), 0, left, right, 0, res);
        return new ArrayList<>(res);
    }

    public void helper(String s, StringBuilder sb, int pos, int left, int right, int open,
                       Set<String> res) {
        if (left < 0 || right < 0 || open < 0) return;
        if (pos == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                System.out.println(sb.toString());
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(pos);
        int length = sb.length();

        if (c == '(') {
            helper(s, sb, pos + 1, left - 1, right, open, res);
            helper(s, sb.append(c), pos + 1, left, right, open + 1, res);
        } else if (c == ')') {
            helper(s, sb, pos + 1, left, right - 1, open, res);
            helper(s, sb.append(c), pos + 1, left, right, open - 1, res);
        } else {
            helper(s, sb.append(c), pos + 1, left, right, open, res);
        }
        sb.setLength(length);
    }
}
