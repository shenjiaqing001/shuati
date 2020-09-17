/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc278 {

    class VersionControl {
        boolean isBadVersion(int version) {
            return false;
        }
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int lo = 1;
            int hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (!isBadVersion(mid)) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }


    public static void main(String[] args) {

    }
}
