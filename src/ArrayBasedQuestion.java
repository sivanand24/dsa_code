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

}
