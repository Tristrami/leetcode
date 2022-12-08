package problems.common.罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{
    private static final Map<String, Integer> romanToInteger = new HashMap<String, Integer>() {{
       put("I", 1); put("IV", 4); put("V", 5); put("IX", 9); put("X", 10); put("XL", 40);
       put("L", 50); put("XC", 90); put("C", 100); put("CD", 400); put("D", 500);
       put("CM", 900); put("M", 1000);
    }};

    public static void main(String[] args)
    {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s)
    {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            String current = String.valueOf(s.charAt(i));
            String currentAndNext = null;
            if (i + 1 < s.length()) {
                currentAndNext = String.valueOf(s.charAt(i)) + s.charAt(i + 1);
            }
            if (currentAndNext != null && romanToInteger.containsKey(currentAndNext)) {
                ans += romanToInteger.get(currentAndNext);
                i += 2;
            } else {
                ans += romanToInteger.get(current);
                i++;
            }
        }
        return ans;
    }
}
