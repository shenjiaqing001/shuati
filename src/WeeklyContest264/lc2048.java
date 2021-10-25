package WeeklyContest264;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc2048 {
    public boolean check(int n) {
        int[] count = new int[10];
        while (n > 0) {
            int digit = n % 10;
            count[digit]++;
            n /= 10;
        }
        for (int i = 0; i < 10; ++i) {
            if (count[i] != 0) {
                if (count[i] != i) return false;
            }
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        n += 1;
        while (!check(n)) {
            n++;
        }
        return n;
    }
}
