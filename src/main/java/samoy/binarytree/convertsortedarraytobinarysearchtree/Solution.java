package samoy.binarytree.convertsortedarraytobinarysearchtree;

import samoy.common.TreeNode;

import java.util.Arrays;

/**
 * @link <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">将有序数组转换为二叉搜索树</a>
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        // 将数组中间位置的数字作为根，视为守卫
        TreeNode node = new TreeNode();
        int midIndex = nums.length / 2;
        node.val = nums[midIndex];
        // 将守卫左侧的数字作为左子树
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
        // 将守卫右侧的数字作为右子树
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex + 1, nums.length));
        return node;
    }
}