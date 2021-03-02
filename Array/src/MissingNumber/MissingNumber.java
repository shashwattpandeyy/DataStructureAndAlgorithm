package MissingNumber;

/*
In this we calculate the sum of arrayNums and subtract it from the total number and we get missing number
Problem Link:
https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalNumber = n*(n+1)/2;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum = sum + nums[i];
        }
        return (totalNumber - sum);

    }
}
