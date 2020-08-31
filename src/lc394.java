/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc394 {
    int nowIndex = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();

        return decode(c);
    }

    public String decode(char[] c) {
        StringBuilder sb = new StringBuilder();
        while (nowIndex < c.length) {
            if (Character.isDigit(c[nowIndex])) {
                int times = getNum(c);
                String s = decode(c);
                for (int j = 0; j < times; ++j) sb.append(s);
            } else if (c[nowIndex] == ']') {
                return sb.toString();
            } else {
                sb.append(c[nowIndex]);
            }
            nowIndex++;
        }
        return sb.toString();
    }

    public int getNum(char[] c) {
        int num = 0;
        while (nowIndex < c.length) {
            if (c[nowIndex] == '[') {
                nowIndex++;
                return num;
            }
            num = num * 10 + (c[nowIndex] - '0');
            nowIndex++;
        }
        return num;
    }
}
