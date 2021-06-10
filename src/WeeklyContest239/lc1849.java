package WeeklyContest239;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1849 {
    public boolean splitString(String s) {
        while (s.charAt(0) == '0') {
            if (s.length() == 1) return false;
            s = s.substring(1);
        }
        if (s.length() <= 1) return false;
        for (int i = 1; i <= (s.length() + 1) / 2; ++i) {
            long num = Long.parseLong(s.substring(0, i));
            if (split(s, i, num)) return true;
        }
        return false;
    }

    public boolean split(String s, int index, long num) {
        if (index == s.length()) return true;
        if (num == 0) {
            for (int i = index; i < s.length(); ++i) {
                if (s.charAt(i) != '0') return false;
            }
            return true;
        }
        for (int i = index + 1; i <= s.length(); ++i) {
            long tmp = Long.parseLong(s.substring(index, i));
            if (tmp >= num) return false;
            if (tmp == num - 1) {
                return split(s, i, tmp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        lc1849 test = new lc1849();
        System.out.println(test.splitString("65432100000"));
    }
}
