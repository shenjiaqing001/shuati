package BiWeeklyContest70;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc4 {
    public int numberOfWays(String corridor) {
        // S seat, P plant
        char[] c = corridor.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'S') count++;
        }
        if (count % 2 != 0) return 0;
        if (count < 2) return 0;
        long res = 1;
        long mod = 1_000_000_007;
        long tmp = 0;
        int countSeat = 0;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'S') {
                if (countSeat == 0) {
                    if (tmp != 0) {
                        res *= tmp;
                        res %= mod;
                        tmp = 1;
                    }
                    countSeat++;
                } else {
                    countSeat = 0;
                    tmp = 1;
                }
            } else {
                if (countSeat == 1) continue;
                else {
                    if (tmp != 0) tmp++;
                }
            }
        }
        return (int) res;
    }
}
