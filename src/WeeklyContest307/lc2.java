package WeeklyContest307;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/20/22
 */
public class lc2 {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; ++i) {
            if (i == 0) {
                if (sb.length() > 0) {
                    for (int j = 0; j < count[i] / 2; ++j) {
                        sb.append(i);
                    }
                }
            } else {
                for (int j = 0; j < count[i] / 2; ++j) {
                    sb.append(i);
                }
            }
        }
        int max = -1;
        for (int i = 9; i >= 0; --i) {
            if (count[i] % 2 == 1) {
                max = i;
                break;
            }
        }
        if (max == -1 && sb.length() == 0) {
            return "0";
        }
        return sb.toString() + (max == -1 ? "" : max) + sb.reverse().toString();
    }
}
