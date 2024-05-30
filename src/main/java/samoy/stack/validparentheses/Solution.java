package samoy.stack.validparentheses;

import java.util.Stack;

/**
 * @link <a href="https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-100-liked">有效的括号</a>
 */
class Solution {
    public boolean isValid(String s) {
        // 使用栈（Stack）数据结构来存储左括号
        Stack<Character> stack = new Stack<>();

        // 遍历字符串s中的每个字符
        for (char c : s.toCharArray()) {
            // 如果遇到左括号，将其压入栈中
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // 否则，当前字符是右括号
            else {
                // 如果栈为空，或者当前右括号与栈顶的左括号不匹配
                if (stack.empty()
                        || c == ')' && stack.getLast() != '('
                        || c == ']' && stack.getLast() != '['
                        || c == '}' && stack.getLast() != '{') {
                    // 返回false，表示字符串无效
                    return false;
                }
                // 如果栈非空且括号匹配，弹出栈顶的左括号
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        // 如果遍历完字符串后栈为空，说明所有括号都已正确配对，返回true
        // 栈非空则说明有未配对的左括号，返回false
        return stack.empty();
    }
}
