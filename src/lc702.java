/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/23
 */
public class lc702 {
    interface ArrayReader {
        public int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == 2147483647) return -1;
        int left = 0;
        int right = 10000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (reader.get(mid) == 2147483647) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            int midNum = reader.get(mid);
            if (midNum == target) return mid;
            if (reader.get(mid) < target) left = mid + 1;
            else {
                right = mid - 1;
            }
        }
        return reader.get(left) == target ? left : -1;
    }
}
