/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc65 {
    public boolean isNumber(String s) {
        s = s.trim();
        int e = s.indexOf('e');
        if (e == -1) {
            return checkLeft(s);
        } else {
            return checkLeft(s.substring(0, e)) &&
                    checkRight(s.substring(e + 1));
        }
    }

    public boolean checkLeft(String s) {
        if (s.length() == 0)
            return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if (s.length() == 0)
            return false;
        if (s.charAt(0) == '.' && s.length() == 1)
            return false;

        boolean hasDot = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '.') {
                if (hasDot == false) {
                    hasDot = true;
                    continue;
                } else {
                    return false;
                }
            }
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean checkRight(String s) {
        if (s.length() == 0)
            return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if (s.length() == 0)
            return false;

        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        lc65 t = new lc65();
        System.out.println(t.isNumber(".1"));
    }


}
