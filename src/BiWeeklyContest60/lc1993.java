package BiWeeklyContest60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1993 {
    class LockingTree {
        Map<Integer, Integer> pMap = new HashMap<>();
        Map<Integer, List<Integer>> cMap = new HashMap<>();
        int root = 0;
        int[] lock;

        public LockingTree(int[] parent) {
            lock = new int[parent.length];
            for (int i = 0; i < parent.length; ++i) {
                if (parent[i] == -1) {
                    root = i;
                    pMap.put(i, parent[i]);
                } else {
                    pMap.put(i, parent[i]);
                    cMap.putIfAbsent(parent[i], new ArrayList<>());
                    cMap.get(parent[i]).add(i);
                }
            }
        }

        public boolean lock(int num, int user) {
            if (lock[num] != 0) return false;
            lock[num] = user;
            return true;
        }

        public boolean unlock(int num, int user) {
            if (lock[num] == user) {
                lock[num] = 0;
                return true;
            } else {
                return false;
            }
        }

        public boolean upgrade(int num, int user) {
            if (lock[num] != 0) return false;
            if (!lockedDes(num)) return false;
            if (lockedAes(num)) return false;
            unlockDes(num);
            lock[num] = user;
            return true;
        }

        public void unlockDes(int num) {
            lock[num] = 0;
            if (!cMap.containsKey(num)) return;
            for (int child : cMap.get(num)) {
                unlockDes(child);
            }
        }


        public boolean lockedAes(int num) {
            if (num == -1) return false;
            if (lock[num] != 0) return true;
            return lockedAes(pMap.get(num));
        }

        public boolean lockedDes(int num) {
            if (lock[num] != 0) return true;
            if (!cMap.containsKey(num)) return false;
            for (int child : cMap.get(num)) {
                if (lockedDes(child)) return true;
            }
            return false;
        }

    }


}
