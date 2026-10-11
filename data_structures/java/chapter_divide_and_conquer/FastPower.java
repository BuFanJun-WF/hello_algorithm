package chapter_divide_and_conquer;

/**
 * 快速幂
 *
 * @Author: wangfan
 * @name: FastPower
 * @Date: 2026/10/10
 */
public class FastPower {
    /** 计算 x 的 n 次幂， n 为非负整数 */
    public static int fastPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int res = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        }
        else {
            return res * res * x;
        }
    }

    /** 计算 x 的 n 次幂， n 为整数 */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? quickMul(x, N) : 1 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if(N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        assert fastPow(7, 0) == 1;
        assert fastPow(3, 5) == 243;
        assert fastPow(2, 6) == 64;
    }
}
