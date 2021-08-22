package WeeklyContest254;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc1967 {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) res++;
        }
        return res;
    }
}
