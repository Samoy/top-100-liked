package samoy.multidimensionaldp.longestpalindromicsubstring;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-100-liked">最长回文串</a>
 */
class Solution {
    public String longestPalindrome(String s) {
        // 如果输入字符串为空或长度为0，直接返回空字符串
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0, end = 0; // 初始化最长回文子串的起始和结束位置

        // 遍历字符串中的每个字符作为潜在的回文中心
        for (int i = 0; i < s.length(); i++) {
            // 分别尝试以i为中心的奇数长度回文和以i和i+1为中心的偶数长度回文
            int len1 = expandAroundCenter(s, i, i); // 奇数长度回文
            int len2 = expandAroundCenter(s, i, i + 1); // 偶数长度回文

            // 取两种情况下得到的最长回文长度
            int len = Math.max(len1, len2);

            // 如果当前找到的回文长度大于已知最长回文长度，则更新最长回文的起始和结束位置
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // 根据找到的起始和结束位置，返回最长回文子串
        return s.substring(start, end + 1);
    }

    // 辅助方法，从中心向两边扩展，寻找以left和right为中心的最长回文子串长度
    public int expandAroundCenter(String s, int left, int right) {
        // 当left和right都在字符串范围内且对应的字符相等时，继续扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; // 向左扩展
            ++right; // 向右扩展
        }

        // 返回实际构成回文的字符数，减1是因为在while循环结束时，左右指针已经越过了回文中心
        return right - left - 1;
    }
}
