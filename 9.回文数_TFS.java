/**
 * 将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。 
 * 但是，如果反转后的数字大于 Integer.MAX_VALUE，我们将遇到整数溢出问题。
 * 为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 int 数字的一半？
 * 毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
 * 如何知道反转数字的位数已经达到原始数字位数的一半？
 * 我们将原始数字除以 10，然后给反转后的数字乘上 10，
 * 所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}