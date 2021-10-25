package WeeklyContest264;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc2047 {
    public int countValidWords(String sentence) {
        int res = 0;
        for (String s : sentence.split(" ")) {
            if (s.length() == 0) continue;
            char[] c = s.toCharArray();
            boolean flag = true;
            int count = 0;
            for (int i = 0; i < c.length; ++i) {
                if (c[i] <= '9' && c[i] >= '0') {
                    flag = false;
                    break;
                }
                if (c[i] == '!' || c[i] == ',' || c[i] == '.') {
                    if (i != c.length - 1) flag = false;
                    break;
                }
                if (c[i] == '-') {
                    if (count == 1) {
                        flag = false;
                        break;
                    }

                    if (i == 0 || i == c.length - 1) {
                        flag = false;
                        break;
                    } else {
                        if (c[i + 1] == '!' || c[i + 1] == '.' || c[i + 1] == ',') {
                            flag = false;
                            break;
                        }
                    }
                    count++;
                }
            }
            if (flag) res++;
        }
        return res;
    }
}
