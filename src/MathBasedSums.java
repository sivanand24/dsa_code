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
}
