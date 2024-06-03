package samoy.dynamicprogramming.longestvalidparentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @link <a href="https://leetcode.cn/problems/longest-valid-parentheses/?envType=study-plan-v2&envId=top-100-liked">最长有效括号</a>
 */
class Solution {
    public int longestValidParentheses(String s) {
        // 使用双端队列（Deque）作为栈，存储左括号的索引
        Deque<Integer> stack = new LinkedList<>();

        // 初始化最长有效括号子串的长度为0
        int max = 0;

        // 将-1压入栈，作为初始边界条件，用于处理开头就是右括号的情况
        stack.push(-1);

        // 遍历输入字符串
        for (int i = 0; i < s.length(); i++) {
            // 获取当前字符
            char ch = s.charAt(i);

            // 如果当前字符是左括号，将其索引压入栈
            if (ch == '(') {
                stack.push(i);
            }
            // 如果当前字符是右括号
            else if (ch == ')') {
                // 弹出栈顶的元素（即最近的一个未匹配的左括号索引）
                stack.pop();

                // 如果弹出后栈为空，说明当前右括号没有匹配的左括号，将当前索引压入栈作为新边界
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                // 如果栈不为空，说明当前右括号与之前的某个左括号匹配成功
                else {
                    // 计算当前有效括号子串的长度，并更新最长有效括号子串的长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        // 返回最长有效括号子串的长度
        return max;
    }
}
