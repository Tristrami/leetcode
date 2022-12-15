package common;

import java.util.ArrayList;
import java.util.List;

public class ListNode
{
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] values)
    {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int value : values) {
            ListNode node = new ListNode(value, null);
            tail.next = node;
            tail = node;
        }
        return head.next;
    }

    public static List<Integer> toArrayList(ListNode list)
    {
        List<Integer> result = new ArrayList<>();
        ListNode p = list;
        while(p != null) {
            result.add(p.val);
            p = p.next;
        }
        return result;
    }
}
