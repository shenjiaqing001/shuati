/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/13
 */
public class lc592 {
    public String fractionAddition(String expression) {
        String[] nums = expression.split("/|(?=[-+])");
        int A = 0, B = 1;
        int couples = nums.length / 2;
        for (int i = 0; i < couples; ++i) {
            int a = Integer.valueOf(nums[2 * i]);
            int b = Integer.valueOf(nums[2 * i + 1]);
//            System.out.println(a + " " + b);
            A = A * b + a * B;
            B *= b;
            int g = gcd(A, B);
            A /= g;
            B /= g;

        }
        return A + "/" + B;
    }

    public int gcd(int a, int b) {
        return a != 0 ? gcd(b % a, a) : Math.abs(b);
    }
}
