package org.example.examination.bytedance;

import org.example.common.TreeNode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 1. 往左找
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // 2. 往右找
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // 找到要删除的节点 root
        else {
            // case1:叶子节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // case2:只有右孩子
            else if (root.left == null) {
                return root.right;
            }
            // case2:只有左孩子
            else if (root.right == null) {
                return root.left;
            }
            // case3:左右都不为空：取右子树最小节点
            else {
                // 找右子树最小值
                TreeNode minNode = findMin(root.right);
                // 替换值
                root.val = minNode.val;
                // 在右子树删除这个最小节点
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    // BST最左就是最小值
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
