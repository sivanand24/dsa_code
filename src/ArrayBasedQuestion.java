import java.util.Arrays;

public class ArrayBasedQuestion {
    // remove duplicate in sorted array
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int officer =0;
        for(int i=1; i< nums.length; i++){
            if(nums[i] != nums[officer]){
                officer++;
                nums[officer] = nums[i];
            }
        }
        return officer +1;
    }

    //find square of elements in array
    public int[] sortedSquares(int[] nums) {

        int[] squaredNum = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            squaredNum[i] = nums[i]*nums[i];
        }
        Arrays.sort(squaredNum);
        return squaredNum;
    }
}
