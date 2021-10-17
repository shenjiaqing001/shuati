package BiWeeklyContest63;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2038 {
    public boolean winnerOfGame(String colors) {
        char[] c = colors.toCharArray();
        int countA = 0;
        int countB = 0;
        for (int i = 1; i < c.length - 1; ++i) {
            if (c[i] == 'A' && c[i - 1] == 'A' && c[i + 1] == 'A') {
                countA++;
            } else if (c[i] == 'B' && c[i - 1] == 'B' && c[i + 1] == 'B') {
                countB++;
            }
        }
        return countA > countB;
    }
}
