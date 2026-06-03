package org.example.practice;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        /*
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k - 1];
         */
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, heapSize-1);
            heapSize--;
            heapify(nums, 0, heapSize);
        }

        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize) {
        // 从第一个非叶子节点开始
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    public void heapify(int[] nums, int index, int heapSize) {
        int left, right, largest;
        for (int i = index; i < heapSize;) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            largest = i;
            if (left < heapSize && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right < heapSize && nums[right] > nums[largest]) {
                largest = right;
            }
            // 这个很重要
            if (i == largest) return;
            swap(nums, i, largest);
            i = largest;
        }
    }

    /**
     * 快速选择
     * 超出时间限制
     */
    public void quickSelect(int[] nums, int left, int right, int k) {
        // 第一步别忘记
        if (left >= right) {
            return;
        }
        int slow = left;
        int fast = left;
        while (fast < right) {
            if (nums[fast] > nums[right]) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        swap(nums, slow, right);

        if (k - 1 == slow) {
            return;
        }
        if (k - 1 < slow) {
            quickSelect(nums, left, slow - 1, k);
        } else {
            quickSelect(nums, slow + 1, right, k);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
