package org.example.practice;

public class FindDuplicate {

    // 2a+2b = a+2b+c
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            // 第一个要后置判断
            if (slow == fast) {
                break;
            }
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // 注意：找到的是环节点的下标，这个下标本身就是重复数字
        return slow;
    }
}
