package WeeklyContest292;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/7/22
 */
public class lc1 {

    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; --i) {
            String s = String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
            if (num.contains(s)) return s;
        }
        return "";
    }


}
