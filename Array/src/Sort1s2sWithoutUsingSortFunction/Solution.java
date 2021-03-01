package Sort1s2sWithoutUsingSortFunction;

public class Solution {
    /*
    this is the function code of sorting array without using sort function.
    this is only function i am not created any Main method this question is present in LeetCode.
    https://leetcode.com/problems/sort-colors/
     */
    public void sortColors(int[] nums) {
        int start = 0;
        int mid = 0;
        int end  = nums.length-1;

        while(mid <= end){
            switch(nums[mid]){
                case 0 : {
                    int temp = nums[mid];
                    nums[mid] = nums[start];
                    nums[start] = temp;
                    start++;
                    mid++;
                    break;
                }

                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    int temp = nums[end];
                    nums[end] = nums[mid];
                    nums[mid] = temp;
                    end--;
                    break;
                }
            }
        }

    }
}
