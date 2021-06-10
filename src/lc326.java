/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/8
 */
public class lc326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 3 == 0) n /= 3;
            else return false;
        }
        return true;
        // return ( n>0 &&  1162261467%n==0);
    }
}
