public class MathBasedSums {
    //palindrome problem using reserve integer logic
    public boolean isPalindrome(int x) {
        int original = x;
        int temp = x;
        int reverse = 0;
        if( x < 0 ){
            return false;
        }
        if(x == 0){
            return true;
        }
        while(temp> 0){
            int digit = temp%10;
            reverse = reverse * 10 + digit;
            temp = temp /10;
            if(reverse == original){
                return true;

            }
        }
        return false;
    }
    //find squareRoot of given number
    public int mySqrt(int x) {
        if (x < 2) return x;

        for (int i = 1; i <= x / 2; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1)) {
                return i;
            }
        }
        return 1;
    }
}
