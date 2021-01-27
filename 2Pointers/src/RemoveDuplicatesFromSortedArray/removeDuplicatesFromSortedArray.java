package RemoveDuplicatesFromSortedArray;


/* PS : Given a sorted array nums, remove the duplicates in-place such that each element appears
        only once and returns the new length.
        this is a method pass parameter is nums you have to create main class includes size of array
        elements in array.
        example nums/input = [0,0,1,1,1,2,2,3,3,4]
        so the given output is  5, nums = [0,1,2,3,4]
        removeDuplicates(nums);
 */
public class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[j] != nums[i]){
                j++;
                nums[j] = nums[i];

            }

        }
        return j+1;

    }
}
