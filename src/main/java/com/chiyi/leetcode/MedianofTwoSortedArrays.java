package com.chiyi.leetcode;

/**
 * @author chiyi
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        if((nums1 ==null || nums1.length ==0)&& (nums2==null||nums2.length==0)){
            return -1.0;
        }
        int len1 = (nums1==null)? 0:nums1.length;
        int len2 = (nums2==null)? 0:nums2.length;
        int len = len1 + len2;
        // merge sort
        int index1 = 0,index2=0,index3=0;
        int[] newArr = new int[len];

        // case1:both nums1 and nums2 have elements
        while(index1<len1 && index2 < len2){
            if (nums1[index1] < nums2[index2]){
                newArr[index3++] = nums1[index1++];
            }else {
                newArr[index3++] = nums2[index2++];
            }
        }

        // case2: only nums1 has elements
        while (index1 < len1){
            newArr[index3++] = nums1[index1++];
        }

        // case3: only nums2 has elements
        while (index2 < len2){
            newArr[index3++] = nums2[index2++];
        }

        // return median for even and odd cases
        int indexM1 = (len -1)/2,indexM2 = len/2;
        if(len%2==0){
            return (newArr[indexM1] + newArr[indexM2])/2.0;
        }else {
            return newArr[indexM2];
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if((nums1 ==null || nums1.length ==0)&& (nums2==null||nums2.length==0)){
            return -1.0;
        }
        int len1 = (nums1==null)? 0:nums1.length;
        int len2 = (nums2==null)? 0:nums2.length;
        int len = len1 + len2;

        // return median for even and odd cases
        if(len%2==0){
            return (findKth(nums1,0,nums2,0,len/2)+findKth(nums1,0,nums2,0,len/2+1))/2.0;
        } else {
            return findKth(nums1,0,nums2,0,len/2+1);
        }
    }

    private int findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
        int len1 = (nums1==null)? 0:nums1.length;
        if(index1 > len1 -1){
            return nums2[index2+k-1];
        }
        int len2 = (nums2==null)? 0:nums2.length;
        if(index2 > len2-1){
            return nums1[index1 +k-1];
        }

        // avoid infilite loop if k ==1
        if(k==1){
            return Math.min(nums1[index1],nums2[index2]);
        }

        int keyA = Integer.MAX_VALUE, keyB = Integer.MAX_VALUE;
        if (index1 + k/2 - 1 < len1){
            keyA = nums1[index1 + k/2 - 1];
        }
        if (index2 + k/2 - 1 < len2){
            keyB = nums2[index2 + k/2 - 1];
        }

        if (keyA > keyB) {
            return findKth(nums1, index1, nums2, index2 + k/2, k - k/2);
        } else {
            return findKth(nums1, index1 + k/2, nums2, index2, k - k/2);
        }
    }

}
