/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc693 {
    public boolean hasAlternatingBits(int n) {
        if (n == 0 || n == 1) return true;
        int last = n % 2;
        n >>= 1;
        while (n > 0) {
            int now = n % 2;
            if (last == now) return false;
            last = now;
            n >>= 1;
        }
        return true;
    }
}
