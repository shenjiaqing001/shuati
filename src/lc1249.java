/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) continue;
                count--;
            }
            sb.append(c);
        }
        StringBuilder res = new StringBuilder();
        for (char c : sb.reverse().toString().toCharArray()) {
            if (c == '(' && count > 0) {
                count--;
                continue;
            }
            res.append(c);
        }
        return res.reverse().toString();
    }

}
