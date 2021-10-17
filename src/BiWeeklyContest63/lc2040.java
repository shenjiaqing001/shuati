package BiWeeklyContest63;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2040 {
    int xa, xb;

    //[-9,6,10]
    //[-7,-1,1,2,3,4,4,6,9,10]
    //15
    public static void main(String[] args) {
        lc2040 test = new lc2040();
        System.out.println(
                test.kthSmallestProduct(new int[]{-9, 6, 10},
                        new int[]{-7, -1, 1, 2, 3, 4, 4, 6, 9, 10}, 15));
    }

    public long kthSmallestProduct(int[] a, int[] b, long k) {
        long lo = Long.MIN_VALUE;
        long hi = Long.MAX_VALUE;
        int n = a.length;
        int m = b.length;
        k = (long) n * (long) m - k;
        xa = n;
        xb = m;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                xa = i;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (b[i] >= 0) {
                xb = i;
                break;
            }
        }
        k++;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (chk(a, b, mid, k)) {
                lo = mid + 1;
            } else
                hi = mid;
        }
        return lo - 1;

    }

    //nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
    //25 - 1 - 3

    boolean chk(int[] a, int[] b, long mid, long k) {
        int i, j;
        int n = a.length;
        int m = b.length;
        int res = 0;
        i = xa;
        j = m - 1;
        while (i < n && j >= xb) {
            if ((long) a[i] * b[j] < mid) {
                i++;
            } else {
                j--;
                res += n - i;
            }
        }
        i = xa - 1;
        j = 0;
        while (i > -1 && j < xb) {
            if ((long) a[i] * b[j] < mid) {
                i--;
            } else {
                j++;
                res += i + 1;
            }
        }
        i = 0;
        j = xb;
        while (i < xa && j < m) {
            if ((long) a[i] * b[j] < mid) {
                i++;
            } else {
                res += xa - i;
                j++;
            }
        }
        i = xa;
        j = 0;
        while (i < n && j < xb) {
            if ((long) a[i] * b[j] < mid) {
                j++;
            } else {
                i++;
                res += xb - j;
            }
        }

        return res >= k;
    }
}
