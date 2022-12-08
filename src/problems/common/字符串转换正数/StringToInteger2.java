package problems.common.字符串转换正数;

import java.util.HashMap;

// 8. 字符串转换整数 (atoi)
// https://leetcode.cn/problems/string-to-integer-atoi/
public class StringToInteger2
{
    public static void main(String[] args)
    {
        System.out.println(myAtoi("   + 123"));
    }

    // 自动状态机，当问题状态较多，并且不同操作会引发状态的切换，就可以考虑使用自动状态机
    // 只需要建立一个状态、新状态与操作的对应表，就可以省去许多复杂的状态判断
    public static int myAtoi(String s)
    {
        Automation automation = new Automation();
        for (int i = 0; i < s.length(); i++) {
            automation.nextState(s.charAt(i));
        }
        return automation.getResult();
    }
}

class Automation
{
    // 当前状态
    private String state = "start";
    // 正负数标志
    private int sign = 1;
    // 计算结果
    private int result = 0;
    // 状态转换表
    private static final HashMap<String, String[]> STATE_TABLE = new HashMap<String, String[]>(){{
        put("start", new String[]{"start", "signed", "inNumber", "end"});
        put("signed", new String[]{"end", "end", "inNumber", "end"});
        put("inNumber", new String[]{"end", "end", "inNumber", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    private int getColumnNumberByHeaderName(char header)
    {
        if (header == ' ') {
            return 0;
        } else if (header == '+' || header == '-') {
            return 1;
        } else if (Character.isDigit(header)) {
            return 2;
        } else {
            return 3;
        }
    }

    public String nextState(char c)
    {
        if (!"end".equals(this.state)) {
            String newState = STATE_TABLE.get(this.state)[getColumnNumberByHeaderName(c)];
            if (newState.equals("signed")) {
                this.sign = c == '+' ? 1 : -1;
            } else if (newState.equals("inNumber")) {
                int digit = sign * (c - '0');
                if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > 7) {
                    result = Integer.MAX_VALUE;
                } else if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && digit < -8) {
                    result = Integer.MIN_VALUE;
                } else {
                    result = result * 10 + digit;
                }
            }
            this.state = newState;
            return newState;
        }
        return "end";
    }

    public String getState()
    {
        return this.state;
    }

    public int getResult()
    {
        return this.result;
    }
}

