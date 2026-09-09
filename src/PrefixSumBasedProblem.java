import java.util.HashMap;

public class PrefixSumBasedProblem {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }

        int left = 0;
        for(int i = 0; i< nums.length; i++){
            int right = sum - nums[i] - left;
            if(left == right){
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
    //subarray sums divided by k prob
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for( int num : nums){
            sum = sum + num;
            int remainder = sum%k;
            if(remainder < 0){
                remainder = remainder + k;
            }
            if(map.containsKey(remainder)){
                count = count + map.get(remainder);
            }
            map.put(remainder , map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }//subarray sum Equals to k

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            sum = sum + num;
            int ans = sum -k;
            if(map.containsKey(ans)){
                count = count + map.get(ans);
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
    //longest Common prefix problem
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j< strs.length; j++){
                if(i>=strs[j].length() || strs[j].charAt(i) != ch ){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
