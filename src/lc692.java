//import javafx.util.Pair;
//
//import java.util.*;
//
///**
// * @author Jiaqing Shen
// * @description
// * @date Created in 8/21/20
// */
//public class lc692 {
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < words.length; ++i) {
//            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
//        }
//
//        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(
//                new Comparator<Pair<String, Integer>>() {
//                    @Override
//                    public int compare(Pair<String, Integer> o1,
//                                       Pair<String, Integer> o2) {
//                        if(o1.getValue() != o2.getValue())
//                            return o1.getValue() - o2.getValue();
//                        else
//                            return o1.getKey().compareTo(o2.getKey());
//                    }
//                });
//
//        for (String kv : map.keySet()) {
//            q.add(new Pair<>(kv, map.get(kv)));
//            if (q.size() > k)
//                q.poll();
//        }
//
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < k; ++i) {
//            res.add(q.poll().getKey());
//        }
//        return res;
//    }
//}
