package org.example.examination;

public class QuickSort {

    public void quickSort(int[] arr,int left,int right){
        if(left>=right) return;
        int pivot = arr[right];
        int slow = left;
        int fast = left;
        while(fast<right){
            if(arr[fast]<pivot){
                swap(arr,slow,fast);
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        swap(arr,slow,right);
        quickSort(arr,left,slow-1);
        quickSort(arr,slow+1,right);
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
