package samoy.substr.minimumwindowsubstring;

/**
 * @link <a href="https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked">最小覆盖子串</a>
 */
class Solution {
    // 主要方法：给定字符串s和t，返回s中包含t所有字符的最小子串，若无则返回""
    public String minWindow(String s, String t) {
        // 将字符串s转为字符数组，便于索引访问
        char[] sCharArray = s.toCharArray();
        // 获取s的长度
        int m = sCharArray.length;

        // 初始化答案子串的左右边界，初始设置为无效(-1, m)
        int ansLeft = -1;
        int ansRight = m;

        // 初始化左右指针
        int left = 0;

        // 记录还需匹配的字符数量
        int less = 0;

        // 分别创建大小为128的计数数组，用于记录s和t中字符出现的次数
        int[] cntS = new int[128];
        int[] cntT = new int[128];

        // 预处理t中的字符计数，同时计算需匹配的字符种类数(less)
        for (char c : t.toCharArray()) {
            if (cntT[c]++ == 0) {
                less++;
            }
        }

        // 使用滑动窗口遍历s
        for (int right = 0; right < m; right++) {
            char c = sCharArray[right];

            // 更新s中字符c的计数，并检查是否满足t的条件，是则减小需匹配字符数
            if (++cntS[c] == cntT[c]) {
                less--;
            }

            // 当当前窗口满足包含t所有字符的条件时
            while (less == 0) {
                // 检查并更新最小覆盖子串
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }

                // 左指针右移，缩小窗口，并还原左指针指向字符的计数
                char x = sCharArray[left++];
                if (cntS[x]-- == cntT[x]) {
                    less++; // 如果移除的字符是t中需要的，需匹配字符数加回
                }
            }
        }

        // 根据答案子串边界返回结果，若未找到则返回空字符串
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}
