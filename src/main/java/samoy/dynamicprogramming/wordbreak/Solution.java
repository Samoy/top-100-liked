package samoy.dynamicprogramming.wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @link <a href="https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-100-liked">单词拆分</a>
 */
class Solution {
    /**
     * 判断字符串s是否可以用字典wordDict中的单词组合表示。
     *
     * @param s        目标字符串
     * @param wordDict 单词字典列表
     * @return 如果可以组合表示则返回true，否则返回false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将wordDict转换为HashSet以提高查找效率
        Set<String> wordDictSet = new HashSet<>(wordDict);

        // 初始化动态规划数组，大小为s长度加1，dp[i]表示s的前i个字符是否可以用字典中的单词表示
        boolean[] dp = new boolean[s.length() + 1];
        // base case，空字符串可以看作是任何字符串的组合
        dp[0] = true;

        // 遍历字符串s的每一个字符
        for (int i = 1; i <= s.length(); i++) {
            // 对于字符串s的前i个字符，检查所有可能的前缀j（0<=j<i）
            for (int j = 0; j < i; j++) {
                // 如果dp[j]为true，表示s的前j个字符可以由字典中的单词组成
                // 并且s[j...i-1]（即s的第j到i-1个字符）在字典中，则dp[i]可以置为true
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // 找到一个匹配即可跳出内层循环，避免重复工作
                    break;
                }
            }
        }

        // 返回最终结果，dp[s.length()]表示整个字符串s是否可以由字典中的单词组成
        return dp[s.length()];
    }
}
