package OnlineAssessment.ByteDance;

import java.util.Scanner;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/24
 */
public class MemoryOOP {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 1; i <= cases; ++i) {
            long M1 = sc.nextLong();
            long M2 = sc.nextLong();

            long diff = Math.abs(M1 - M2);
            long idx = (long) Math.sqrt((diff + 1) * 2 + Math.sqrt((diff + 1) * 2)) - 1;
            long total = (1 + idx) * idx / 2;
            if (M1 > M2) M1 -= total;
            else M2 -= total;
            idx++;

            System.out.println(idx + " " + M1 + " " + M2);
        }
    }
}