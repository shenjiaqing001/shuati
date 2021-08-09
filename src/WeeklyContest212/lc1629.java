package WeeklyContest212;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/25
 */
public class lc1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] c = keysPressed.toCharArray();
        int last = 0;
        int max = 0;
        int maxchar = 0;
        for (int i = 0; i < releaseTimes.length; ++i) {
            if (releaseTimes[i] - last > max) {
                max = releaseTimes[i] - last;
                maxchar = c[i] - 'a';
            } else if (releaseTimes[i] - last == max) {
                maxchar = Math.max(maxchar, c[i] - 'a');
            }
            last = releaseTimes[i];
        }
        return (char) (maxchar + 'a');
    }
}
