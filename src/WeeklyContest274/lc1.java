package WeeklyContest274;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/1/22
 */
public class lc1 {
    public boolean checkString(String s) {
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (flag == true) return false;
            } else {
                if (flag == false) {
                    flag = true;
                }
            }
        }
        return true;
    }

}
