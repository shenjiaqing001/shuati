/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/6
 */
public class lc43 {
    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        int[] cRes = new int[c1.length + c2.length];
        for (int i = c1.length - 1; i >= 0; --i) {
            int carry = 0;
            for (int j = c2.length - 1; j >= 0; --j) {
                int k = (c1.length - i - 1) + (c2.length - j - 1);
                int num = (c1[i] - '0') * (c2[j] - '0') + cRes[k] + carry;
                cRes[k] = num % 10;
                carry = num / 10;
            }
            if (carry > 0) {
                int k = (c1.length - i - 1) + (c2.length - 1) + 1;
                cRes[k] = carry;
            }
        }
        int last = cRes.length - 1;
        for (; last >= 0; --last) {
            if (cRes[last] != 0) break;
        }
        StringBuilder sb = new StringBuilder();
        while (last >= 0) {
            sb.append(cRes[last--]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
