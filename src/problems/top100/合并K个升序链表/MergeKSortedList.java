package problems.top100.合并K个升序链表;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

// 23. 合并K个升序链表
// https://leetcode.cn/problems/merge-k-sorted-lists/
public class MergeKSortedList
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

    public static ListNode mergeKLists(ListNode[] lists)
    {
        // 1 3 5 7 8
        // 2 4 6 8 10
        // 1 4 7 8 9
        // 类似合并两个有序链表，使用 n 个指针，每次找出所有最小值添加到结果集中并将他们的指针后移
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        ListNode[] pointer = new ListNode[lists.length];
        initPointer(lists, pointer);
        while (true) {
            List<Integer> minPointerIndexes = findMinPointer(pointer);
            if (minPointerIndexes.isEmpty()) {
                break;
            } else {
                for (int i = 0; i < minPointerIndexes.size(); i++) {
                    int index = minPointerIndexes.get(i);
                    ListNode minPointer = pointer[index];
                    ListNode node = new ListNode(minPointer.val);
                    tail.next = node;
                    tail = node;
                    // 将指针后移
                    pointer[index] = pointer[index].next;
                }
            }
        }
        return dummyHead.next;
    }

    // 初始化所有指针指向链表头
    public static void initPointer(ListNode[] lists, ListNode[] pointer)
    {
        System.arraycopy(lists, 0, pointer, 0, lists.length);
    }

    // 在由 pointer 数组指向的元素形成的列表中寻找最小值，并返回他们的引用
    public static List<Integer> findMinPointer(ListNode[] pointer)
    {
        List<Integer> minimums = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pointer.length; i++) {
            if (pointer[i] != null) {
                if (pointer[i].val < min) {
                    min = pointer[i].val;
                    // 如果找到新的最小值，清空之前保存的所有最小值所在节点的引用
                    minimums.clear();
                }
                if (pointer[i].val == min) {
                    minimums.add(i);
                }
            }
        }
        return minimums;
    }
}