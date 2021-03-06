package com.payphone.offer2;

public class Offer068 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Offer068 v = new Offer068();
    }
}
