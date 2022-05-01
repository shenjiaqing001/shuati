package WeeklyContest271;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc3 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        if (plants.length <= 2) return 0;
        int n = plants.length;

        int leftA = capacityA;
        int leftB = capacityB;
        int lo = 0;
        int hi = n - 1;
        int count = 0;
        while (lo <= hi) {
            if (lo == hi) {
                if (leftA >= plants[lo] || leftB >= plants[lo]) {

                } else {
                    count++;
                }
                break;
            }

            if (leftA >= plants[lo]) {
                leftA -= plants[lo];
            } else {
                count++;
                leftA = capacityA - plants[lo];
            }

            if (leftB >= plants[hi]) {
                leftB -= plants[hi];
            } else {
                count++;
                leftB = capacityB - plants[hi];
            }

            lo++;
            hi--;
        }

        return count;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        System.out.println(test.minimumRefill(
                new int[]{2, 1, 1}, 2
                , 2));
    }
}
