/**
 * 反转整数的方法可以与反转字符串进行类比。
 * 我们想重复“弹出” x 的最后一位数字，并将它“推入”到 rev 的后面。最后，rev 将与 x 相反。
 * pop operation:
 * pop = x % 10;
 * x /= 10;
 * push operation:
 * temp = rev * 10 + pop;
 * rev = temp;
 * 但当 temp = rev * 10 + pop 时会导致溢出，所以还要进行结果是否溢出的检查。
 */
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}