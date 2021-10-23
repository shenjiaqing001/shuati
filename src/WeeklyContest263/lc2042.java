package WeeklyContest263;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2042 {
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int last = 0;
        for (String str : strs) {
            try {
                int num = Integer.parseInt(str);
                if (num <= last) return false;
                last = num;
            } catch (Exception e) {

            }
        }
        return true;
    }
}
