package problems.top100.删除链表的倒数第N个结点;

// 19. 删除链表的倒数第N个结点
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList
{
    public static void main(String[] args)
    {

    }

    // 快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null) return null;
        // 1 2 3 4
        // 创建一个空的头节点，让 pre 指向这个头节点，这样 pre 就可以指向 slow 的前一个节点
        ListNode dummyHead = new ListNode(0, head);
        // 使用快慢指针，当 fast 指向第 n 个节点时，slow 开始向后移动，当 fast 移动到最后一个
        // 节点时，slow 也就指向倒数第 n 个节点了
        ListNode fast = head, slow = head, pre = dummyHead;
        // 让 fast 指向第 n 个节点
        for (int i = 0; fast != null && i + 1 < n; i++, fast = fast.next);
        // 寻找倒数第 n 个节点
        for (; fast.next != null; fast = fast.next, slow = slow.next, pre = pre.next);
        // 删除倒数第 n 个节点
        pre.next = slow.next;
        slow.next = null;
        // 不能直接返回 head，因为当 head 链表中只有一个元素时，执行上面的删除操作后 head 不为 null
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
