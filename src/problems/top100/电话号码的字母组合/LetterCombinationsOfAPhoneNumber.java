package problems.top100.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. 电话号码的字母组合
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber
{
    public static void main(String[] args)
    {
        System.out.println(letterCombinations("2"));
    }

    // 搜索回溯
    public static List<String> letterCombinations(String digits)
    {
        Map<Character, String> numToStr = new HashMap<Character, String>(){{
            put('2', "abc"); put('3', "def");
            put('4', "ghi"); put('5', "jkl"); put('6', "mno");
            put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");
        }};
        List<String> combinations = new ArrayList<>();
        search(digits, numToStr, new StringBuilder(), combinations, digits.length());
        return combinations;
    }


    public static void search(String digits, Map<Character, String>numToStr, StringBuilder combination, List<String> combinations, int len)
    {
        if (digits.length() == 0) return;
        String letters = numToStr.get(digits.charAt(0));
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            search(digits.substring(1), numToStr, combination, combinations, len);
            // 回溯之后上一个状态的组合字符串的最后一个字符已经被删除，而题目只需要 combination.length() == len 的组合字符串
            if (combination.length() == len) {
                combinations.add(combination.toString());
            }
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
