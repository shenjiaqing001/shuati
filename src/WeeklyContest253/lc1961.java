package WeeklyContest253;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1961 {
    public boolean isPrefixString(String s, String[] words) {
        String str = "";
        for (String tmp : words) {
            str = str + tmp;
            if (s.equals(str)) return true;
        }
        return false;
    }
}
