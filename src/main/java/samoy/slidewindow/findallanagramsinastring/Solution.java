package samoy.slidewindow.findallanagramsinastring;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked">找到字符串中所有字母异位词</a>
 */
class Solution {
    /*
    使用排序解决
    时间复杂度：O(n*m log m)，其中m是字符串p的长度
    空间复杂度：O(n)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int start = i;
            int end = i + p.length();
            char[] sChars = new char[p.length()];
            int j = 0;
            while (start < end) {
                sChars[j++] = s.charAt(start);
                start++;
            }
            Arrays.sort(sChars);
            if (Arrays.equals(pChars, sChars)) {
                result.add(i);
            }
        }
        return result;
    }

    /*
    使用滑动窗口
    时间复杂度：O(n+m+Σ)，其中 n 为字符串 s 的长度，m 为字符串 p 的长度，其中Σ为所有可能的字符数。
    空间复杂度：O(Σ)。用于存储滑动窗口和字符串 ppp 中每种字母数量的差。
     */
    public List<Integer> findAnagrams2(String s, String p) {
        // 获取s和p的长度
        int sLen = s.length(), pLen = p.length();

        // 如果s的长度小于p的长度，无法形成匹配的异位词，返回空列表
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        // 初始化结果列表，用于存储所有匹配的起始索引
        List<Integer> result = new ArrayList<>();

        // 初始化两个大小为26的数组，分别存储s和p中每个字符的计数
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 遍历p，更新pCount
        for (int i = 0; i < pLen; ++i) {
            // 将字符计数增加1，'a'用于将字符映射到数组索引
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        // 如果sCount和pCount相等，说明s的第一个pLen长度的子串是p的异位词，添加索引0到结果列表
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        // 遍历s的剩余部分，更新sCount
        for (int i = 0; i < sLen - pLen; ++i) {
            // 移除子串起始位置的字符
            --sCount[s.charAt(i) - 'a'];
            // 添加新的尾部字符
            ++sCount[s.charAt(i + pLen) - 'a'];

            // 检查sCount是否与pCount相等，如果相等，说明找到一个异位词子串，添加索引到结果列表
            if (Arrays.equals(sCount, pCount)) {
                result.add(i + 1);
            }
        }

        // 返回结果列表
        return result;
    }

}
