package samoy.binarytree.constructbinarytreefrompreorderandinordertraversal;

import samoy.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked">从前序遍历与中序遍历序列构建二叉树</a>
 */
class Solution {

    /*
      此题可画图解决：
      前序遍历：        根    ------------左-----------                --------------右----------------
      坐标：        preLeft  preLeft+1         pIndex-inLeft+preLeft  pIndex-inLeft+preLeft+1     preRight

      中序遍历：----------左-----------         根         --------------右----------------
      坐标：   inLeft         pIndex-1       pIndex       pIndex+1                   inRight

     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int rootValue = preorder[preLeft];
        int pIndex = map.get(rootValue);
        TreeNode node = new TreeNode(rootValue);
        // 递归构建左子树
        node.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1, map);
        // 递归构建右子树
        node.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight, map);
        return node;
    }
}