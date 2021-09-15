/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/15
 */
public class lc917 {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int index = c.length - 1;
        for (int i = 0; i < c.length; ++i) {
            if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
                while (!((c[index] >= 'a' && c[index] <= 'z') ||
                        (c[index] >= 'A' && c[index] <= 'Z')))
                    index--;
                sb.append(c[index--]);
            } else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
}
