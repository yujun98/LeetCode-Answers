/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (52.68%)
 * Total Accepted:    49.7K
 * Total Submissions: 93.7K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; } 
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ListNode tmpln = ln;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmpln.next = l2;
                tmpln = tmpln.next;
                l2 = l2.next;
            }
            else if (l2 == null) {
                tmpln.next = l1;
                tmpln = tmpln.next;
                l1 = l1.next;
            }
            else {
                if (l1.val < l2.val) {
                    tmpln.next = l1;
                    tmpln = tmpln.next;
                    l1 = l1.next;
                }
                else {
                    tmpln.next = l2;
                    tmpln = tmpln.next;
                    l2 = l2.next;
                }
            }
        }
        return ln.next;
    }
}
