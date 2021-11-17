package WeeklyContest267;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class lc2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        char[] c = encodedText.toCharArray();
        int n = encodedText.length();
        int cols = n / rows;
        int x = 0, y = 0;
        while (x * cols + y != cols) {
            sb.append(c[x * cols + y]);
            x += 1;
            y += 1;
            if (x >= rows || y >= cols) {
                y -= x - 1;
                x = 0;
            }
        }
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
