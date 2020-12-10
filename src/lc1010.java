/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/9
 */
public class lc1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for (int i = 0; i < time.length; ++i) {
            mod[time[i] % 60]++;
        }
        int res = 0;
        res += mod[0] * (mod[0] - 1) / 2;
        res += mod[30] * (mod[30] - 1) / 2;
        for (int i = 1; i <= 29; ++i) {
            res += mod[i] * mod[60 - i];
        }
        return res;
    }
}
