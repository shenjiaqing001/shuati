/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/14
 */
public class lc357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1 + 9;
        if (n == 2) return 1 + 9 + 81;
        if (n == 3) return 1 + 9 + 81 + 648;
        if (n == 4) return 1 + 9 + 81 + 648 + 4536;
        if (n == 5) return 1 + 9 + 81 + 648 + 4536 + 27216;
        if (n == 6) return 1 + 9 + 81 + 648 + 4536 + 27216 + 136080;
        if (n == 7) return 1 + 9 + 81 + 648 + 4536 + 27216 + 136080 + 544320;
        if (n == 8) return 1 + 9 + 81 + 648 + 4536 + 27216 + 136080 + 544320 + 1632960;
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(9);
        System.out.println(9 * 9);
        System.out.println(9 * 9 * 8);
        System.out.println(9 * 9 * 8 * 7);
        System.out.println(9 * 9 * 8 * 7 * 6);
        System.out.println(9 * 9 * 8 * 7 * 6 * 5);
        System.out.println(9 * 9 * 8 * 7 * 6 * 5 * 4);
        System.out.println(9 * 9 * 8 * 7 * 6 * 5 * 4 * 3);
    }
}
