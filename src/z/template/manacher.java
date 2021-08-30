package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/30
 */
public class manacher {


    public static void main(String[] args) {
        manacher test = new manacher();
        System.out.println(test.maxPalindrome("aab"));
    }

    public int maxPalindrome(String string) {
        if (string == null || string == "") return 0;
        if (string.length() == 1) return 1;

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : string.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }

        char[] c = sb.toString().toCharArray();
        int[] radius = new int[c.length];
        int center = -1;
        int r = -1;
        int max = 0;
        for (int i = 0; i < c.length; ++i) {
            radius[i] = r > i ? Math.min(radius[2 * center - r], r - i + 1) : 1;
            while (i + radius[i] < c.length && i - radius[i] > -1) {
                if (c[i - radius[i]] == c[i + radius[i]]) {
                    radius[i]++;
                } else break;
            }
            if (i + radius[i] > r) {
                r = i + radius[i] - 1;
                center = i;
            }
            max = Math.max(max, radius[i]);
        }
        return max - 1;
    }
}
