package WeeklyContest252;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/31
 */
public class lc1954 {
    //0 0
    //2 4 * 3  (1 2)             3   3 * 1 ^ 2
    //4 4 * 12 (3 2 3 4)         15  3*  2 ^ 2
    //6 4 * 27 (5 4 3 4 5 6)     42  3 * 3 ^ 2
    //8 $ *    (7 6 5 4 5 6 7 8)     3 * 4 ^ 2  * 4

    //
    //n(n+1)(2n+1)/6


    public long minimumPerimeter(long neededApples) {
        long n = 1;
        while (2 * n * (2 * n + 1) * (n + 1) < neededApples) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        long[] dp = new long[100];


    }
}
