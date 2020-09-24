/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/24
 */
public class lc400 {
    public int findNthDigit(int n) {
        // 1-9 9
        // 10-99 180
        // 100-999 2700
        // 1000- 9999 36000
        long length = 1;
        long index = 1;
        while (n - length * 9 * index >= 0) {
            n -= length * 9 * index;
            length *= 10;
            index += 1;
        }


        int num = (int) ((n - 1) / index);
        int res = (int) (index + num);
        String res2 = String.valueOf(res);
        System.out.println();
        return res2.charAt((int) ((n - 1) % length)) - '0';
    }
}
