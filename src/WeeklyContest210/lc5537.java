package WeeklyContest210;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc5537 {
    // abdef
    // fecab
    public boolean checkPalindromeFormation(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int length = a.length() / 2;
        boolean flag = true;
        for (int i = 0; i < length; ++i) {
            if (as[i] != as[a.length() - i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag == true) return true;

        flag = true;
        for (int i = 0; i < length; ++i) {
            if (bs[i] != bs[b.length() - i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag == true) return true;

        flag = true;
        boolean isTrans = false;
        for (int i = 0; i < length; ++i) {
            if (isTrans == false) {
                if (as[i] != bs[b.length() - i - 1]) {
                    isTrans = true;
                    i--;
                }
            } else {
                if (as[i] != as[a.length() - i - 1]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) return true;

        flag = true;
        isTrans = false;

        for (int i = 0; i < length; ++i) {
            if (isTrans == false) {
                if (bs[i] != as[b.length() - i - 1]) {
                    isTrans = true;
                    i--;
                }
            } else {
                if (bs[i] != bs[a.length() - i - 1]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) return true;

        flag = true;
        isTrans = false;

        for (int i = 0; i < length; ++i) {
            if (isTrans == false) {
                if (bs[i] != as[b.length() - i - 1]) {
                    isTrans = true;
                    i--;
                }
            } else {
                if (as[i] != as[a.length() - i - 1]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) return true;

        flag = true;
        isTrans = false;

        for (int i = 0; i < length; ++i) {
            if (isTrans == false) {
                if (as[i] != bs[b.length() - i - 1]) {
                    isTrans = true;
                    i--;
                }
            } else {
                if (bs[i] != bs[a.length() - i - 1]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) return true;


        return false;
    }
}
