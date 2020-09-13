package WeeklyContest206;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc5514 {
    public boolean isTransformable(String s, String t) {
        int n = s.length();
        int[] countS = new int[10];
        int[] countT = new int[10];

        List<Integer>[] reverseS = new List[10];

        for (char c : s.toCharArray()) {
            int num = c - '0';
            int reverse = 0;
            for (int i = 0; i < num; ++i) reverse += countS[i];
            countS[num]++;
            if (reverseS[num] == null) reverseS[num] = new LinkedList<>();
            reverseS[num].add(reverse);
        }

        for (char c : t.toCharArray()) {
            int num = c - '0';
            int reverse = 0;
            for (int i = 0; i < num; ++i) reverse += countT[i];
            countT[num]++;

            if (reverseS[num] == null || reverseS[num].size() == 0) return false;
            System.out.println(reverse + " " + reverseS[num].get(0));
            if (reverseS[num].remove(0) > reverse) return false;
        }
        return true;
    }
}
