package CSCI761;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class KnapsackSubsets {

    public int problemPartA(int[] weights, int n, int capacity, int mod) {
        int[] res = new int[capacity + 1];
        res[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = capacity; j >= 0; --j) {
                if (j - weights[i] >= 0 && res[j - weights[i]] > 0) {
                    res[j] += res[j - weights[i]];
                    res[j] %= mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= capacity; ++i) {
            sum += res[i];
            sum %= mod;
        }
        return sum;
    }

    public void problemPartB(int[] weights, int n, int capacity, int mod) {

    }

    public static void main(String[] args) {
        KnapsackSubsets ks = new KnapsackSubsets();

        System.out.println(ks.problemPartA(new int[]{47, 12, 27, 35, 12, 21, 9, 12, 38, 13}, 10, 100, 6577));
    }

}
//47
//12
//27
//35
//12
//21
//9
//12
//38
//13
