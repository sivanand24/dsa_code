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
    //best time to buy and sell stocks
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for( int price: prices){
            maxProfit = Math.max(maxProfit,price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
    // best time to buy and sell stocks(version 2)
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for(int i =1; i< prices.length; i++){
            profit = profit + Math.max(0,prices[i] -prices[i-1]);
        }
        return profit;
    }
    //is power of two or not
    public boolean isPowerOfTwo(int n) {
        if(n<= 0) return false;
        while(n%2==0){
            n /= 2;
        }
        return n == 1;
    }
    //version 2 of isPowerOfTwo
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    //smallest even multiple
    public int smallestEvenMultiple(int n) {
        if(n%2 != 0){
            return n *2;
        }
        else if( n%2== 0){
            return n;
        }
        return n;
    }
    //richest customer wealth
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for(int[] customer : accounts){
            int wealth = 0;
            for(int money : customer){
                wealth = wealth + money;
                richest = Math.max(richest , wealth);
            }
        }
        return richest;
    }
    //row with maximum ones
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = -1;
        int rowIdx = 0;
        for(int i = 0; i < mat.length; i++){
            int ones = 0;
            for(int value : mat[i]){
                if(value == 1){
                    ones++;
                }
            }
            if(ones > maxOnes){
                maxOnes = ones;
                rowIdx = i;
            }
        }
        return new int[] {rowIdx , maxOnes};
    }
}
