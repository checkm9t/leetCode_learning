package org.example.leetcode;

import org.example.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    // 迭代的写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        // 条件：root不为空 或者 栈里面还有节点没处理
        while (root != null || !stk.isEmpty()) {
            // 1.一路向左，把整条左链全部压入栈
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 2.弹出栈顶：这就是最左没有左孩子的节点
            root = stk.pop();
            res.add(root.val); //访问根
            // 3.转向右子树，下一轮循环处理右子树
            root = root.right;
        }
        return res;
    }

}
