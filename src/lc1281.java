/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/19
 */
public class lc1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int add = 0;
        while (n > 0) {
            product *= n % 10;
            add += n % 10;
            n /= 10;
        }
        return product - add;
    }
}
