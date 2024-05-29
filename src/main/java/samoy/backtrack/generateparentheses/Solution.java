package samoy.backtrack.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">括号生成</a>
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        // 初始化结果列表
        ArrayList<String> ans = new ArrayList<>();

        // 当n为0时，没有有效的括号组合，直接返回空列表
        if (n == 0) return ans;

        // 调用回溯方法，初始字符串为空，左右括号数均等于n
        backtrack(ans, "", n, n);

        // 返回结果列表
        return ans;
    }

    // 回溯方法，用于递归生成所有可能的括号组合
    private void backtrack(ArrayList<String> ans, String str, int left, int right) {
        // 当左右括号都用完时，当前str是一个有效的括号组合，将其添加到答案列表中
        if (left == 0 && right == 0) {
            ans.add(str);
            return;
        }

        // 如果left和right相等，接下来出现的一定是左括号
        if (left == right) {
            backtrack(ans, str + "(", left - 1, right);
        }
        // 如果left小于right，下一个可以时左括号，也可以是右括号
        else if (left < right) {
            if (left > 0) {
                backtrack(ans, str + "(", left - 1, right);
            }
            // 添加右括号并减少right的计数
            backtrack(ans, str + ")", left, right - 1);
        }
    }
}
