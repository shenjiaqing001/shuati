import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/2/22
 */
public class lc1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        String[] words = text.split(" ");
        TreeSet<String> set = new TreeSet<>();

        Map<String, List<String>> map = new HashMap<>();
        for (List<String> list : synonyms) {
            map.putIfAbsent(list.get(0), new ArrayList<>());
            map.putIfAbsent(list.get(1), new ArrayList<>());
            map.get(list.get(0)).add(list.get(1));
            map.get(list.get(1)).add(list.get(0));
        }

        Map<String, Set<String>> changeMap = new HashMap<>();
        Map<String, String> point = new HashMap<>();
        for (String key : map.keySet()) {
            if (!point.containsKey(key)) {
                point.put(key, key);
                changeMap.put(key, new HashSet<>());
                changeMap.get(key).add(key);
                Queue<String> q = new ArrayDeque<>();
                q.add(key);
                while (!q.isEmpty()) {
                    String now = q.poll();
                    for (String next : map.get(now)) {
                        if (!point.containsKey(next)) {
                            point.put(next, key);
                            changeMap.get(key).add(next);
                            q.add(next);
                        }
                    }
                }
            }
        }

        dfs(set, words, 0, changeMap, point, "");
        List<String> res = new ArrayList<>();
        for(String s : set){
            res.add(s);
        }
        return res;
    }

    public void dfs(TreeSet<String> set, String[] words, int index,
                    Map<String, Set<String>> changeMap, Map<String, String> point, String tmp) {
        if (index == words.length) {
            set.add(tmp);
            return;
        }

        if (point.containsKey(words[index])) {
            String key = point.get(words[index]);
            for (String canChange : changeMap.get(key)) {
                if (tmp.equals("")) dfs(set, words, index + 1, changeMap, point, canChange);
                else dfs(set, words, index + 1, changeMap, point, tmp + " " + canChange);
            }
        } else {
            if (tmp.equals("")) dfs(set, words, index + 1, changeMap, point, words[index]);
            else dfs(set, words, index + 1, changeMap, point, tmp + " " + words[index]);
        }
    }
}
