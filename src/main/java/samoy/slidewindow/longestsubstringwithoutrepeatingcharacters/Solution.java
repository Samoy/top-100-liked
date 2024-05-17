package samoy.slidewindow.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @link <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked">无重复字符的最长字串</a>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 初始化哈希映射和两个指针
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLength = 0;

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 如果字符已经在哈希映射中，找到对应的索引
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                // 移动到重复字符的下一个位置
                start = Math.max(start, map.get(character) + 1);
            }
            // 更新哈希映射
            map.put(character, i);
            // 最大长度要么为之前的最大长度，要么为当前字符串的长度
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
