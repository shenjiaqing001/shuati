/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 1;
        int right = x / 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left * left <= x) return left;
        else return left - 1;
    }

    public static void main(String[] args) {
        lc69 t = new lc69();
        System.out.println(t.mySqrt(9));
    }
}
