/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/27
 */
public class lc374 {
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (true) {
            int mid = (hi - lo) / 2 + lo;
            int g = guess(mid);
            if (g == 0) return mid;

            if (g == -1) hi = mid -1;
            else if (g == 1) lo = mid + 1;
        }
    }


}
