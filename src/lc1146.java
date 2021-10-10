import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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

    class SnapshotArray2 {

        TreeMap<Integer, Integer>[] list;
        int time = 0;

        public SnapshotArray2(int length) {
            list = new TreeMap[length];
            for (int i = 0; i < length; ++i) {
                list[i] = new TreeMap<>();
                list[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            list[index].put(time, val);
        }

        public int snap() {
            return time++;
        }

        public int get(int index, int snap_id) {
            return list[index].floorEntry(snap_id).getValue();
        }
    }
}
