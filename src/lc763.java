import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] max = new int[26];


        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            max[chars[i] - 'a'] = i;
        }

        int tmpMax = max[chars[0] - 'a'];
        int last = -1;
        for (int i = 0; i < chars.length; ++i) {
            tmpMax = Math.max(tmpMax, max[chars[i] - 'a']);
            if (tmpMax == i) {
                res.add(i - last);
                last = i;
                tmpMax = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc763 t = new lc763();
        List<Integer> res = t.partitionLabels("ababcbacadefegdehijhklij");
        for(Integer i : res){
            System.out.println(i);
        }
    }

}
