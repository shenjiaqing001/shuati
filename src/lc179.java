import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/20/20
 */
public class lc179 {
    public String largestNumber(int[] nums) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                int minLen = Math.min(s1.length(), s2.length());
                for (int t = 0; t < minLen; ++t) {
                    if (s1.charAt(t) == s2.charAt(t)) continue;
                    return s2.charAt(t) - s1.charAt(t);
                }
                if (s1.length() == s2.length()) return 0;
                String s3 = s1 + s2;
                String s4 = s2 + s1;
                for (int t = 0; t < s3.length(); ++t) {
                    if (s3.charAt(t) == s4.charAt(t)) continue;
                    return s4.charAt(t) - s3.charAt(t);
                }
                return 0;
            }
        };
        Integer[] ints = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(ints, cmp);
        String str = "";
        for (Integer i : ints)
            str = str + i.toString();
        if (str.charAt(0) == '0') return "0";
        return str;
    }


    public static void main(String[] args) {
        lc179 t = new lc179();
        int[] ints = {3, 30, 34, 5, 9};
        System.out.println(t.largestNumber(ints));
    }
}
