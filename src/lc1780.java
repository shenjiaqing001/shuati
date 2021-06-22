/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/22
 */
public class lc1780 {
    public boolean checkPowersOfThree(int n) {
        int[] num =
                new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683,
                        59049, 177147, 531441, 1594323, 4782969};

        int index = 14;
        while (index >= 0) {
            if (n >= num[index]) n -= num[index];
            index--;
        }

        return n == 0;
    }

    public static void main(String[] args) {
        int n = 1;
        while (n <= 10000000) {
            System.out.print(n + " ,");
            n *= 3;
        }
    }

}
