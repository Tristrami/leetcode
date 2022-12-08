package problems.common.回文数;

// 9. problems.common.回文数
// https://leetcode.cn/problems/palindrome-number/
public class PalindromeNumber
{
    public static void main(String[] args)
    {
        System.out.println(isPalindrome(-123));
    }

    public static boolean isPalindrome(int x)
    {
        if (x < 0) return false;
        int[] nums = new int[32];
        int size = 0;
        while (x != 0) {
            nums[size++] = x % 10;
            x /= 10;
        }
        for (int i = 0, j = size - 1; i <= j; ) {
            if (nums[i] != nums[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
