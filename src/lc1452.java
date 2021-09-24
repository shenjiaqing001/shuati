import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/18
 */
public class lc1452 {
    public static void main(String[] args) {
        lc1452 test = new lc1452();
        List<List<String>> fc = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("leetcode");
        a.add("google");
        a.add("facebook");
        List<String> b = new ArrayList<>();
        b.add("microsoft");
        b.add("google");
        List<String> c = new ArrayList<>();
        c.add("google");
        c.add("facebook");
        List<String> d = new ArrayList<>();
        d.add("google");
        List<String> e = new ArrayList<>();
        e.add("amazon");
        fc.add(a);
        fc.add(b);
        fc.add(c);
        fc.add(d);
        fc.add(e);
        test.peopleIndexes(fc);
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Map<String, BitSet> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (String company : favoriteCompanies.get(i)) {
                map.putIfAbsent(company, new BitSet(n));
                map.get(company).set(i);
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            BitSet bs = new BitSet(100);
            bs.set(0, n);
            for (String company : favoriteCompanies.get(i)) {
                bs.and(map.get(company));
            }
            if (bs.cardinality() == 1) res.add(i);
        }
        return res;
    }
}
