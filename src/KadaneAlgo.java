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
    //minimum subarray using kadane algo
    public int minSubarraySum(int[] arr) {
        int bestending = arr[0];
        int ans = arr[0];
        for(int i =1;i<arr.length;i++){
            int v1 = bestending + arr[i];
            int v2 = arr[i];
            bestending = Math.min(v1,v2);
            ans = Math.min(ans,bestending);
        }

        return ans;
    }
    //maximum product subarray
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int minEnding = nums[0];
        int maxEnding = nums[0];
        for(int i = 1; i < nums.length; i++){
            int v1 = nums[i];
            int v2 = minEnding * nums[i];
            int v3 = maxEnding * nums[i];
            minEnding = Math.min(v1 , Math.min(v2,v3)); //to handle negative multiplication
            maxEnding = Math.max(v1 , Math.max(v2,v3)); //to handle positive multiplication
            res = Math.max(res,Math.max(minEnding,maxEnding));
        }
        return res;
    }
}
