package OnlineAssessment.NOIP普及组2020;

import java.util.Scanner;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/12
 */
public class p2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rate = sc.nextInt();

        int[] num = new int[601];

        for (int i = 1; i <= n; ++i) {
            int score = sc.nextInt();
            num[score]++;
            int k = (i * rate) / 100;
            if (k < 1) k = 1;

            for (int j = 600; j >= 0; --j) {
                k-=num[j];
                if(k<=0){
                    System.out.print(j+" ");
                    break;
                }
            }
        }
    }
}
