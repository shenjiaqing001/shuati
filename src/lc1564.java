import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/10
 */
public class lc1564 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        for (int i = 1; i < warehouse.length; ++i) {
            if (warehouse[i] > warehouse[i - 1]) warehouse[i] = warehouse[i - 1];
        }
        int i = 0;
        int j = warehouse.length-1;
        int res = 0;
        while (i < boxes.length && j>=0) {
            System.out.println(boxes[i]+" " + warehouse[j]);
            if (boxes[i] <= warehouse[j]) {
                i++;
                j--;
                res++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc1564 t = new lc1564();
//        t.maxBoxesInWarehouse();
    }
}
