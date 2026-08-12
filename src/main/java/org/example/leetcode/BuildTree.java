package org.example.leetcode;

import org.example.common.TreeNode;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuild(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode myBuild(int[] preorder, int preorderL, int preorderR,
                            int[] inorder, int inorderL, int inorderR) {
        if (preorderL > preorderR || inorderL > inorderR) {
            return null;
        }

        int val = preorder[preorderL];
        TreeNode node = new TreeNode(val);
        int mid;
        for (mid = inorderL; mid <= inorderR; mid++) {
            if (inorder[mid] == val) {
                break;
            }
        }

        // 这个用于计算preorder的左右边界
        int leftSize = mid - inorderL;

        // preorder的左右边界计算需要注意
        node.left = myBuild(preorder, preorderL + 1, preorderL + leftSize,
                inorder, inorderL, mid - 1);

        node.right = myBuild(preorder, preorderL + leftSize + 1, preorderR,
                inorder, mid + 1, inorderR);

        return node;
    }
}
