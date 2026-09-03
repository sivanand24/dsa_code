public class KadaneAlgo {
    //maximum subarray using kadane algo
    public int maxSubArray(int[] nums) {
        int bestending = nums[0];
        int ans = nums[0];
        for(int i =1; i<nums.length;i++){
            int v1 = bestending + nums[i];
            int v2 = nums[i];
            bestending = Math.max(v1,v2);
            ans = Math.max(ans,bestending);
        }
        return ans;
    }
}
