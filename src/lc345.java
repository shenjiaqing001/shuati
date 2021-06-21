/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/12
 */
public class lc345 {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (true) {
            while (left < right &&
                    !(c[left] == 'a' || c[left] == 'e' || c[left] == 'i' || c[left] == 'o' ||
                            c[left] == 'u' || c[left] == 'A' || c[left] == 'E' || c[left] == 'I' ||
                            c[left] == 'O' || c[left] == 'U')) {
                left++;
            }
            while (left < right &&
                    !(c[right] == 'a' || c[right] == 'e' || c[right] == 'i' || c[right] == 'o' ||
                            c[right] == 'u' || c[right] == 'A' || c[right] == 'E' ||
                            c[right] == 'I' || c[right] == 'O' || c[right] == 'U')) {
                right--;
            }

            if (left >= right) break;

            char tmp = c[left];
            sb.setCharAt(left, c[right]);
            sb.setCharAt(right, tmp);
            left++;
            right--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc345 test = new lc345();
        System.out.println(test.reverseVowels("leetcode"));
    }
}
