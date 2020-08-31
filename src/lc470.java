import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc470 {

    class SolBase {
        public int rand7() {
            return 0;
        }
    }

    class Solution extends SolBase {
        public int rand10() {
            while (true) {
                int num = (rand7() - 1) * 7 + rand7();
                if (num <= 40) return num % 10 + 1;
            }

        }
    }
}
