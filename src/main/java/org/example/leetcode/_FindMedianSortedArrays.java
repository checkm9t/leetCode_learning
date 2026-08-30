package org.example.leetcode;

// 寻找两个正序数组的中位数
// leetcode 4
public class _FindMedianSortedArrays {


    /**
     nums[1]是短数组的话，二分效率更高
     左边取较大的一半的话，在奇数时可以直接取左边两个中最大的
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int leftHalf = (n1 + n2 + 1) / 2;

        int left = 0;
        int right = n1;

        // i表示nums1有几个元素在左半部分
        int i = 0;
        int j = 0;
        while (left <= right) {
            i = (left + right) / 2;
            j = leftHalf - i;

            int num1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int num2 = j == n2 ? Integer.MAX_VALUE : nums2[j];

            // i没有过大，可以继续往右找
            // 因为i找的是最大满足点，所以，找到i时，j也会满足条件，所以只用判断一边的条件
            if (num1 <= num2) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        // 因为满足条件时还要往右找，并且，一定是right<left，所以取right
        i = right;
        j = leftHalf - i;

        int num11 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num12 = i == n1 ? Integer.MAX_VALUE : nums1[i];
        int num21 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num22 = j == n2 ? Integer.MAX_VALUE : nums2[j];

        if ((n1 + n2) % 2 == 1) {
            return Math.max(num11, num21);
        } else {
            return (Math.max(num11, num21) + Math.min(num12, num22)) / 2.0;
        }

    }
}
