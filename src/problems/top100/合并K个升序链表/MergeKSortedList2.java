package problems.top100.合并K个升序链表;

import common.ListNode;

import java.util.List;
import java.util.PriorityQueue;

// 23. 合并K个升序链表
// https://leetcode.cn/problems/merge-k-sorted-lists/
public class MergeKSortedList2
{
    public static void main(String[] args)
    {
        ListNode[] lists = new ListNode[]{
                ListNode.createList(new int[]{ 1, 3, 5, 7, 9 }),
                ListNode.createList(new int[]{ 2, 4, 6, 8, 10 }),
                ListNode.createList(new int[]{ 1, 4, 7, 8, 9 })
        };
        List<Integer> result = ListNode.toArrayList(mergeKLists(lists));
        System.out.println(result);
    }

    // 优先队列
    public static ListNode mergeKLists(ListNode[] lists)
    {
        // 1 3 5 7 8
        // 2 4 6 8 10
        // 1 4 7 8 9
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        PriorityQueue<QueueNode> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(new QueueNode(list.val, list.next));
            }
        }
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            ListNode listNode = new ListNode(queueNode.val, queueNode.next);
            tail.next = listNode;
            tail = listNode;
            if (queueNode.next != null) {
                queue.add(new QueueNode(queueNode.next.val, queueNode.next.next));
            }
        }
        return dummyHead.next;
    }
}

class QueueNode implements Comparable<QueueNode>
{
    public int val;
    public ListNode next;

    public QueueNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    @Override
    public int compareTo(QueueNode node)
    {
        return this.val - node.val;
    }
}