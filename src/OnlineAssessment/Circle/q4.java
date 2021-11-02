package OnlineAssessment.Circle;

import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/1
 */
public class q4 {
    String booleanDeque(int n, String[] operations) {
        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            set.add(i);
        }
        for (String op : operations) {
            if (op.equals("L")) {
                if (set.isEmpty()) continue;
                int index = set.first();
                set.remove(index);
                arr[index] = 1;
            } else {
                int index = Integer.valueOf(op.substring(1));
                if (arr[index] == 1) {
                    arr[index] = 0;
                    set.add(index);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
