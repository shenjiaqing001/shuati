import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/18
 */
public class lc1244 {
    class Leaderboard {

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> treemap = new TreeMap<>(Collections.reverseOrder());

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            if (!map.containsKey(playerId)) {
                map.put(playerId, score);
                treemap.put(score, treemap.getOrDefault(score, 0) + 1);
            } else {
                int preScore = map.get(playerId);
                treemap.put(preScore, treemap.get(preScore) - 1);
                if (treemap.get(preScore) == 0) {
                    treemap.remove(preScore);
                }
                int newScore = preScore + score;
                map.put(playerId, newScore);
                treemap.put(newScore, treemap.getOrDefault(newScore, 0) + 1);
            }
        }

        public int top(int K) {
            int res = 0;
            for (Integer key : treemap.keySet()) {
                if (treemap.get(key) <= K) {
                    res += key * treemap.get(key);
                    K -= treemap.get(key);
                } else {
                    res += key * K;
                    K = 0;
                }
                if (K == 0) break;
            }
            return res;
        }

        public void reset(int playerId) {
            int preScore = map.get(playerId);
            treemap.put(preScore, treemap.get(preScore) - 1);
            if (treemap.get(preScore) == 0) {
                treemap.remove(preScore);
            }
            map.remove(playerId);
        }
    }
}
