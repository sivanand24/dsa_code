public class PrefixSumBasedProblem {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }
        if(sum==2){
            return 0;
        }
        int left = 0;
        for(int i = 1; i< nums.length; i++){
            left = left + nums[i-1];
            int right = sum - left - nums[i];
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
