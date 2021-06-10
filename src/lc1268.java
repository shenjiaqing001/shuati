import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/31
 */
public class lc1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String product : products) {
            for (int i = 1; i <= product.length(); ++i) {
                String tmp = product.substring(0, i);
                map.putIfAbsent(tmp, new ArrayList<>());
                map.get(tmp).add(product);
            }
        }
        for (int i = 1; i <= searchWord.length(); ++i) {
            List<String> tmpList = new ArrayList<>();
            String tmp = searchWord.substring(0, i);
            if (map.containsKey(tmp)) {
                map.get(tmp).sort((o1, o2) -> o1.compareTo(o2));
                if (map.get(tmp).size() > 3) {
                    tmpList.add(map.get(tmp).get(0));
                    tmpList.add(map.get(tmp).get(1));
                    tmpList.add(map.get(tmp).get(2));
                } else {
                    tmpList = map.get(tmp);
                }
            }
            res.add(tmpList);
        }
        return res;
    }
}
