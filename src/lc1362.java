/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc1362 {
    public int[] closestDivisors(int num) {
        int[] a = closest(num + 1);
        int[] b = closest(num + 2);
        if (a[1] - a[0] > b[1] - b[0]) return b;
        else return a;
    }

    public int[] closest(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = sqrt; i >= 1; --i) {
            if (num % i == 0)
                return new int[]{i, num / i};
        }
        return new int[]{1, num};
    }
}
