/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/28
 */
public class lc405 {
    public String toHex(int num) {
        char[] c =
                new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        long n = num;
        if (n < 0) n += 2147483647 * 2 + 2;

        System.out.println(n);

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, c[(int) (n & 15)]);
            n /= 16;
        }
        return sb.toString();
    }
}
