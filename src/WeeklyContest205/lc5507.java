package WeeklyContest205;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc5507 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int n = c.length - 1;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == '?') {
                char left = ' ';
                char right = ' ';
                if (i > 0) left = c[i - 1];
                if (i < n) right = c[i + 1];
                for (char j = 'a'; j <= 'z'; ++j) {
                    if (j != left && j != right) {
                        c[i] = j;
                        break;
                    }
                }
            }
        }

        for (char tmp : c)
            sb.append(tmp);

        return sb.toString();
    }
}
