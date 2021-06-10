import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/10
 */
public class lc1580 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int res = 0;

        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = 0; i < warehouse.length; ++i) {
            if (warehouse[i] <= min) {
                min = warehouse[i];
                pos = i;
            }
        }

        for (int i = 1; i < pos; ++i) {
            if (warehouse[i] > warehouse[i - 1]) {
                warehouse[i] = warehouse[i - 1];
            }
        }
        for (int i = warehouse.length - 1; i > pos; --i) {
            if (warehouse[i - 1] > warehouse[i]) {
                warehouse[i - 1] = warehouse[i];
            }
        }
        Arrays.sort(warehouse);

        int i = 0;
        int j = 0;

        while (i < boxes.length && j < warehouse.length) {
            if (boxes[i] <= warehouse[j]) {
                i++;
                j++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));

        list.add(new Integer(3));
        list.remove(1);
        System.out.println(list);
    }
}
