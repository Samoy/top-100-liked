package samoy.hash.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked">字母异位词分组</a>
 */
public class Solution {
    public List<List<String>> groupAnagrams(List<String> strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String sortedString = new String(array);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(s);
            map.put(sortedString, list);
        }
        return List.copyOf(map.values());
    }
}