package com.chiyi.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            int area = calArea(height, low, high);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
            maxArea = maxArea > area ? maxArea : area;
        }
        return maxArea;
    }

    private int calArea(int[] height, int low, int high) {
        return (high - low) * Integer.min(height[low], height[high]);
    }
}
