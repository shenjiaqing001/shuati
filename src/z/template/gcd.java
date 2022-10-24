package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/12/11
 */
public class gcd {
    public int gcd(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
