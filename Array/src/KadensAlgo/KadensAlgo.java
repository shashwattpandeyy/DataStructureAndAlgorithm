package KadensAlgo;

public class KadensAlgo {
    /*
    We find the longest subsequence in an array. we know that largest subsequence is always +ve.
    So if there is any -ve number in sum we directly do sum = 0;
    and if sum is non negative then we check if this is greater than max or not if it is greater then we
    simply return it.
    if we see we always do sum after the for loop and check after every sum.
     */
    int maxSubarraySum(int arr[], int n){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            sum = sum+arr[i];
            if(sum < 0){
                sum = 0;
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;


    }

}
