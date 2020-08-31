/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/11/20
 */
public class lc274 {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] >= citations.length)
                count[citations.length]++;
            else
                count[citations[i]]++;
        }

        int res = 0;
        for (int i = citations.length; i >= 0; --i) {
            if (res > i)
                return i + 1;
            res += count[i];
        }
        return 0;
    }

    //1 1 0 1 0 2
    public static void main(String[] args) {
        lc274 t = new lc274();
        System.out.println(t.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
