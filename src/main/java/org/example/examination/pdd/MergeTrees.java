package org.example.examination.pdd;

import org.example.common.TreeNode;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 递归终止条件：有一个为空，直接返回另一个
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        // 前序：处理当前节点
        TreeNode node = new TreeNode(root1.val + root2.val);
        // 递归合并左子树、右子树
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
