package WeeklyContest250;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] strs = text.split(" ");
        int res = 0;
        for (String str : strs) {
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if (brokenLetters.indexOf(c) != -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) res++;
        }
        return res;
    }
}
