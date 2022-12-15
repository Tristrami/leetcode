package problems.top100.两数相加;

import common.ListNode;

import java.util.*;

// 2. problems.top100.两数相加
class AddTwoNumbers
{
    public static void main(String[] args)
    {
        ListNode l1 = ListNode.createList(new int[]{ 9,9,9,9,9,9,9 });
        ListNode l2 = ListNode.createList(new int[]{ 9,9,9,9 });
        System.out.println(ListNode.toArrayList(addTwoNumbers(l1, l2)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode();
        ListNode tail = result;
        int[] carry = new int[100];
        int i = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry[i];
            if (sum > 9) {
                if (p1.next != null || p2.next != null) {
                    sum %= 10;
                    carry[i + 1] = 1;
                }
            }
            tail = insert(tail, sum);
            p1 = p1.next;
            p2 = p2.next;
            i++;
        }
        if (p1 != null) {
            while (p1 != null) {
                int sum = p1.val + carry[i];
                if (sum > 9) {
                    if (p1.next != null) {
                        sum %= 10;
                        carry[i + 1] = 1;
                    }
                }
                tail = insert(tail, sum);
                p1 = p1.next;
                i++;
            }
        } else if (p2 != null) {
            while (p2 != null) {
                int sum = p2.val + carry[i];
                if (sum > 9) {
                    if (p2.next != null) {
                        sum %= 10;
                        carry[i + 1] = 1;
                    }
                }
                tail = insert(tail, sum);
                p2 = p2.next;
                i++;
            }
        }
        return result.next;
    }

    public static ListNode insert(ListNode tail, int val)
    {
        if (val == 0) {
            ListNode newNode = new ListNode(val, null);
            tail.next = newNode;
            tail = newNode;
        } else {
            while (val != 0) {
                ListNode newNode = new ListNode(val % 10, null);
                tail.next = newNode;
                tail = newNode;
                val /= 10;
            }
        }
        return tail;
    }
}