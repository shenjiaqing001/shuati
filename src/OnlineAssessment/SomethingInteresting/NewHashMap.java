package OnlineAssessment.SomethingInteresting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/10
 */
public class NewHashMap {

    int xOffset;
    int yOffset;
    Map<Integer, Integer> map = new HashMap<>();

    public void insert(int x, int y) {
        x -= xOffset;
        y -= yOffset;
        map.put(x, y);
    }

    public int get(int x) {
        x -= xOffset;
        return map.get(x) + yOffset;
    }

    public void addToKey(int x) {
        this.xOffset += x;
    }

    public void addToValue(int y) {
        this.yOffset += y;
    }

}
