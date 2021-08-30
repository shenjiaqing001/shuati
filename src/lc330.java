/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/29
 */
public class lc330 {
    public static void main(String[] args) {
        lc330 test = new lc330();
        test.minPatches(new int[]{1, 2, 31, 33}, 2147483647);

//        long a = 2147483647;
//        int b = 20;
//        long c = a + b;

//        System.out.println(c);
    }

    public int minPatches(int[] nums, int n) {
        long sum = 0;
        long now = 1;
        int index = 0;
        int count = 0;
        while (now <= n) {
            if (index >= nums.length) {
                count++;
                sum += now;
                now = now * 2;
            } else {
                if (now < nums[index]) {
                    sum += now;
                    now = now * 2;
                    count++;
                } else {
                    sum += nums[index++];
                    now = sum + 1;
                }
            }
        }
        return count;
    }
}
