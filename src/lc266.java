/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/1
 */
public class lc266 {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean flag = false;
        for (int i = 0; i < 256; ++i) {
            if (count[i] % 2 == 1) {
                if (flag == false) flag = true;
                else return false;
            }
        }
        return true;
    }
}
