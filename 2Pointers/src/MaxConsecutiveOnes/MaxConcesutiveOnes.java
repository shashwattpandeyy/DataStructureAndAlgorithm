package MaxConsecutiveOnes;

/*      PS : find the maximum number of consecutive 1s in this array.
        This is a method pass parameter is nums you have to create main class includes size of array
        elements in array.
        Input: [1,1,0,1,1,1]
        Output: 3
        findMaxConsecutiveOnes(nums);
 */

public class MaxConcesutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int max =0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] == 0)
                count =0;
            else
                count++;

            if(max < count)max = count;
        }
        return max;
    }
}
