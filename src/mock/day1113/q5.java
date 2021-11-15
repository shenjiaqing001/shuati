package mock.day1113;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/13
 */
public class q5 {
    //现在有最多1e9颗棋子，编号从0开始递增排列。我们要将其染成黑色或者白色。有以下几个方法可以调用：
    //void setBlack(int i) 把第i颗棋子染成黑色
    //void setWhite(int i) 把第i颗棋子染成白色
    //void setAllBlack() 把所有棋子染成黑色
    //void setAllWhile() 把所有棋子染成白色
    //int getValue(int i) 返回第i颗棋子的颜色（1代表黑，0代表白)

    public class ChessBoard {
        static final boolean BLACK = true;
        static final boolean WHITE = false;
        boolean flag = WHITE; // false white, true black
        Set<Integer> set = new HashSet<>();

        void setBlack(int i) {
            if (flag == WHITE) set.add(i);
            else set.remove(i);
        }

        void setWhite(int i) {
            if (flag == BLACK) set.add(i);
            else set.remove(i);
        }

        void setAllBlack() {
            flag = true;
            set.clear();
        }

        void setAllWhile() {
            flag = false;
            set.clear();
        }

        //（1代表黑，0代表白)
        int getValue(int i) {
            if (set.contains(i)) return flag == WHITE ? 1 : 0;
            else return flag == WHITE ? 0 : 1;
        }
    }
}
