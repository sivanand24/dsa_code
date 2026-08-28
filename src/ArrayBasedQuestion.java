import java.util.*;

public class ArrayBasedQuestion {
    // remove duplicate in sorted array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int officer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[officer]) {
                officer++;
                nums[officer] = nums[i];
            }
        }
        return officer + 1;
    }

    //find square of elements in array
    public int[] sortedSquares(int[] nums) {

        int[] squaredNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squaredNum[i] = nums[i] * nums[i];
        }
        Arrays.sort(squaredNum);
        return squaredNum;
    }
// find the square of arr element in optimized way
    public static int[] squareOfSum(int[] nums){
        int n = nums.length;;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for(int num : nums){
            if(num <0){
                neg.add(num);
            } else {
                pos.add(num);
            }
        }
        //for no negative element
        if(neg.size()==0){
            for(int i =0; i<pos.size(); i++){
                pos.set(i,pos.get(i)*pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }
        //for no positive number
        if(pos.size()==0){
            for(int i =0; i<neg.size(); i++){
                neg.set(i,neg.get(i)*neg.get(i));
            }
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }
        // if the array contains both positive nad negative element
        int n1 = neg.size();
        int n2 = pos.size();
        int i =0, j=0, id = 0;
        int[] res = new int[n1 + n2];

        for( i =0; i<n1; i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }
        Collections.reverse(neg);

        for( i =0; i<n2; i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }
        while(i < n1&& j<n2){
            if(neg.get(i)<= pos.get(i)){
                res[id++] = neg.get(i++);
            }
            else {
                res[id++] = pos.get(j++);

            }
        }
        while(i <n1){
            res[id++] = neg.get(i++);
        }
        while(j<n2){
            res[id++] = pos.get(j++);
        }


return res;
    }
    //two sum approach using two pointer
    int[] arr = { 2,7,11,15};
    public static boolean twoSum(int[] arr, int target){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length -1;
        while(i<j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                return true;
            }else if(sum>target){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
    //3sum problem using two pointer approach
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length-2; i++){
            if(i>0 && nums[i] ==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] +nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left -1]){
                        left++;
                    }
                    while(left<right && nums[right] == nums[right +1]){
                        right--;
                    }
                }
                else if(sum <0){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
    // 3sum problem where triplet is smaller than target
    int countTriplets(int sum, int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        int count =0;
        for(int i = 0;i<n-2;i++){
            int left = i +1;
            int right = n-1;
            while(left<right){
                int total = arr[i] + arr[left] + arr[right];
                if(total < sum){
                    count += right-left;
                    left++;
                } else {
                    right--;
                }

            }
        }
        return count ;

    }
    //Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = k-1; //cuz if k =2 then high would be indexed of 1
        int sum =0;
        for(int i =low; i<=high;i++){
            sum = sum + arr[i];
        }
        int res = 0;
        while(high<n){
            res = Math.max(res,sum);
            low++;
            high++;
            if(high == n){
                break;
            }
            sum = sum - arr[low-1];
            sum = sum + arr[high];
        }
        return res;
    }
    //minimum size subarray sum problem
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(high<n){
            sum = sum + nums[high];
            while(sum >=target){
                int len = high - low + 1;
                res  = Math.min(res,len);
                sum = sum - nums[low];
                low++;
            }
            high++;
        }
        return res==Integer.MAX_VALUE?0 : res;
    }
    public int longestKSubstr(String s, int k) {
        Set<Character> set = new HashSet<>();
        int low = 0;
        int res = Integer.MIN_VALUE;
        for(int high = 0; high<s.length(); high++){
            char current = s.charAt(high);
            while(set.contains(current)){
                set.remove(s.charAt(low));
                low++;
            }
            set.add(current);

            int len = high - low +1;
            res = Math.max(res,len);
        }
        return res == Integer.MIN_VALUE?-1:res;

    }
    //rotating the array using the two pointer approach
    public void reverseArr(int[] nums,int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k %n;
        reverseArr(nums,0,n-1);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,n-1);

    }
    //longest substring with at most k unique problem
    public int longestKSubstring(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int low  = 0;
        int res  = Integer.MIN_VALUE;
        for(int high = 0; high<s.length(); high++){
            char  ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char lowChar = s.charAt(low);
                map.put(lowChar,map.get(lowChar)-1);
                if(map.get(lowChar)==0){
                    map.remove(lowChar);
                }
                low++;
            }
            int len = high -low +1;
            res = Math.max(res, len);
        }
        return res;
    }
    // fruits in basket sum (similar to longest subarray at most k =2
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int low =0;
        int k = 2;
        int res = Integer.MIN_VALUE;
        for(int high = 0; high<fruits.length; high++){
            int highnum = fruits[high];
            map.put(highnum,map.getOrDefault(highnum,0)+1);
            while( map.size()>k){
                int lownum = fruits[low];
                map.put(lownum,map.get(lownum)-1);
                if(map.get(lownum)==0){
                    map.remove(lownum);
                }
                low++;
            }
            int len = high - low +1;
            res = Math.max(res,len);
        }
        return res;
    }
    //longest repeating character replacement problem - important
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int low = 0;
        int res = Integer.MIN_VALUE;
        int maxCount = 0;
        for(int high =0;high<s.length();high++){
            int highIndex = s.charAt(high) - 'A';
            count[highIndex]++;
            maxCount = Math.max(maxCount, count[highIndex]);
            int len = high -low +1;
            int diff = len - maxCount;
            while(diff>k){
                int lowIndex = s.charAt(low)- 'A';
                count[lowIndex]--;
                low++;
                len = high -low +1;
                diff = len - maxCount;

            }
            len  = high - low +1;
            res = Math.max(res,len);
        }
        return res;
    }
    //max consecutive ones |||
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int zeros = 0;
        int res = Integer.MIN_VALUE;
        for(int high =0; high<nums.length;high++){
            if(nums[high]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[low]==0){
                    zeros--;
                }
                low++;
            }
            int len = high - low +1;
            res = Math.max(res , len);
        }
        return res;
    }
    //max consecutive ones simple problem
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int high = 0; high < nums.length;high++){
            if(nums[high]==1){
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max , count);
        }
        return max;
    }
    //moves zeros
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0;right <nums.length;right++){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

        }
    }
    //remove elements
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int right = 0;right <nums.length;right++){
            if(nums[right]!=val){
                nums[left]= nums[right];
                left++;
            }
        }
        return left;
    }

}
