/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/7
 */
public class lc825 {
    /**
     * age[B] <= 0.5 * age[A] + 7
     * age[B] > age[A]
     * age[B] > 100 && age[A] < 100
     * <p>
     * 1 <= ages.length <= 20000.
     * 1 <= ages[i] <= 120.
     */
    public int numFriendRequests(int[] ages) {
        int[] age = new int[121];
        for (int i = 0; i < ages.length; ++i) {
            age[ages[i]]++;
        }
        int res = 0;
        for (int i = 1; i <= 120; ++i) {
            if (age[i] == 0) continue;
            for (int j = 1; j <= 120; ++j) {
                if (age[j] == 0) continue;
                if (request(i, j)) {
                    res += age[i] * (age[j] - (i == j ? 1 : 0));
                }

            }
        }
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
}
