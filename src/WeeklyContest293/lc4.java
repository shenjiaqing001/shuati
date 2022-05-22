package WeeklyContest293;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/14/22
 */
public class lc4 {
    class CountIntervals {
        class Node {
            int left;
            int right;
            Node leftChild;
            Node rightChild;
            boolean flag = false;
            int sum = 0;

            Node(int left, int right) {
                this.left = left;
                this.right = right;
            }

            void add(int leftBound, int rightBound) {
                if (flag) return;
                if (left > rightBound || right < leftBound) {
                    return;
                }
                if (leftBound <= left && right <= rightBound) {
                    sum = right - left + 1;
                    flag = true;
                } else {
                    if (leftChild == null) {
                        int mid = (right - left) / 2 + left;
                        leftChild = new Node(left, mid);
                        rightChild = new Node(mid + 1, right);
                    }
                    leftChild.add(leftBound, rightBound);
                    rightChild.add(leftBound, rightBound);
                    this.sum = leftChild.sum + rightChild.sum;
                }
            }
        }

        Node root;

        public CountIntervals() {
            root = new Node(1, 1_000_000_000);
        }

        public void add(int left, int right) {
            root.add(left, right);
        }

        public int count() {
            return root.sum;
        }
    }

}
