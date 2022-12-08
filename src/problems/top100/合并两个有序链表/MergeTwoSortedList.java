package problems.top100.合并两个有序链表;

// 21. 合并两个有序链表
// https://leetcode.cn/problems/merge-two-sorted-lists/
public class MergeTwoSortedList
{
    // 双指针法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        // 1 2 4 6
        // 1 3 4 5
        ListNode dummyHead = new ListNode(0, null);
        ListNode p1 = list1, p2 = list2, tail = dummyHead;
        while (p1 != null && p2 != null) {
            ListNode node;
            if (p1.val < p2.val) {
                node = new ListNode(p1.val, null);
                p1 = p1.next;
            } else {
                node = new ListNode(p2.val, null);
                p2 = p2.next;
            }
            tail.next = node;
            tail = node;
        }
        // 将 list1 或 list2 剩余的节点加入 dummyHead 链表
        while (p1 != null) {
            ListNode node = new ListNode(p1.val, null);
            tail.next = node;
            tail = node;
            p1 = p1.next;
        }
        while (p2 != null) {
            ListNode node = new ListNode(p2.val, null);
            tail.next = node;
            tail = node;
            p2 = p2.next;
        }
        return dummyHead.next;
    }
}

class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
