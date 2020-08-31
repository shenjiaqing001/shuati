/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc415 {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        int carry = 0;

        int i = c1.length - 1;
        int j = c2.length - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? c1[i] - '0' : 0;
            int b = j >= 0 ? c2[j] - '0' : 0;
            sb.append((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
