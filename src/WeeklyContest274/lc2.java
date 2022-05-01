package WeeklyContest274;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/1/22
 */
public class lc2 {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int last = 0;
        for (String s : bank) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') count++;
            }
            res += count * last;
            if (count != 0) last = count;
        }
        return res;
    }
}
