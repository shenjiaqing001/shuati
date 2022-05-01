package WeeklyContest282;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/26/22
 */
public class lc1 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) res++;
        }
        return res;
    }
}
