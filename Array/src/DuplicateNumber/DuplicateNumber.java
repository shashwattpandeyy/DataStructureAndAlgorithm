package DuplicateNumber;

public class DuplicateNumber {
    /*
    We are using slow and fast pointer approach to find duplicate number it is just like a linked list cycle.
    problem link: https://leetcode.com/problems/find-the-duplicate-number/
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

        }
        while(slow != fast);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
