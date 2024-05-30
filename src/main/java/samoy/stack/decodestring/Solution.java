package samoy.stack.decodestring;

/**
 * @link <a href="https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked">字符串解码</a>
 */
class Solution {
    public String decodeString(String s) {
        return solve(s, 0).first;
    }

    // 辅助方法，递归地解码字符串
    private Pair<String, Integer> solve(String s, int i) {
        int multi = 0; // 用于存储当前重复次数
        StringBuilder sb = new StringBuilder(); // 用于构建解码后的字符串

        // 遍历字符串s
        while (i < s.length()) {
            char c = s.charAt(i);

            // 如果字符是数字，累加到multi
            if (Character.isDigit(c)) {
                multi = multi * 10 + c - '0';
            }
            // 如果遇到左方括号，递归解码子串
            else if (c == '[') {
                Pair<String, Integer> subAns = solve(s, i + 1);
                i = subAns.second;
                // 重复子串multi次
                while (multi > 0) {
                    sb.append(subAns.first);
                    multi--;
                }
            }
            // 如果遇到右方括号，返回解码后的子串和下一个字符的位置
            else if (c == ']') {
                return new Pair<>(sb.toString(), i);
            }
            // 其他字符直接添加到解码字符串中
            else {
                sb.append(c);
            }
            i++;
        }
        // 如果没有遇到右方括号，直接返回解码后的字符串和当前位置
        return new Pair<>(sb.toString(), i);
    }

    // 自定义Pair类，用于存储解码后的子串和下一个字符的位置
    static class Pair<T, U> {
        T first;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}


