package RainwaterTrapping;
/*      PS : Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
        how much water it is able to trap after raining.

        An element of the array can store water if there are higher bars on left and right. The amount of water to be
        stored in every element can be found out by finding the heights of bars on the left and right sides. The idea is
        to compute the amount of water that can be stored in every element of the array.

        This is a method pass parameter is building heights in form of array you have to create main class includes
        size of array elements in array.

        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
 */

public class rainwaterTrapping {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];

        for(int i =1; i<n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        for(int i = n-1-1; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }

        int sum =0;
        int[] water = new int[n];

        for(int i =0;i<n; i++){
            water[i] = Math.min(left[i],right[i]) - height[i];
            sum += water[i];
        }

        return sum;
    }
}
