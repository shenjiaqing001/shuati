import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc1146 {


    class SnapshotArray {
        int time = 0;
        int length = 0;
        List<TreeMap<Integer, Integer>> list = new ArrayList<>();

        public SnapshotArray(int length) {
            list = new ArrayList<>();
            for (int i = 0; i < length; ++i) {
                list.add(new TreeMap<>());
                list.get(i).put(0, 0);
            }
        }

        public void set(int index, int val) {
            list.get(index).put(time, val);
        }

        public int snap() {
            time++;
            return time - 1;
        }

        public int get(int index, int snap_id) {
            return list.get(index).floorEntry(snap_id).getValue();
        }
    }
}
