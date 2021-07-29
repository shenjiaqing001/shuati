package OnlineAssessment.NOIP普及组2020;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/12
 */
public class p1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        int now = 2;
        while (now <= n) {
            now *= 2;
        }
        now /= 2;

        while (n > 0 && now >= 2) {
            if (n >= now) {
                list.add(now);
                n -= now;
                now /= 2;
            } else {
                now /= 2;
            }
        }
        if (n != 0) System.out.println(-1);
        else {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
