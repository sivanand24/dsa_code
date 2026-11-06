public class BitwiseBasedProblem {
    //XOR Operation in an Array
    public int xorOperation(int n, int start) {
        int result =0;
        for (int i= 0; i < n; i++){
            result = result ^ (start +2 * i);
        }
        return result;
    }
}
