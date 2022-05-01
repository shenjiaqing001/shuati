package WeeklyContest279;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/5/22
 */
public class lc3 {
    class Bitset {
        int[] arr;
        int count = 0;
        boolean flip = false;

        public Bitset(int size) {
            arr = new int[size];
        }

        public void fix(int idx) {
            if (flip) {
                if (arr[idx] == 0) {

                } else {
                    arr[idx] = 0;
                    count++;
                }
            } else {
                if (arr[idx] == 1) {

                } else {
                    arr[idx] = 1;
                    count++;
                }
            }
        }

        public void unfix(int idx) {
            if (flip) {
                if (arr[idx] == 0) {
                    arr[idx] = 1;
                    count--;
                } else {

                }
            } else {
                if (arr[idx] == 1) {
                    arr[idx] = 0;
                    count--;
                } else {

                }
            }
        }

        public void flip() {
            flip = !flip;
            count = arr.length - count;
        }

        public boolean all() {
            return count == arr.length;
        }

        public boolean one() {
            return count >= 1;
        }

        public int count() {
            return count;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                if (flip) sb.append(1 - num);
                else sb.append(num);
            }
            return sb.toString();
        }
    }

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
}
