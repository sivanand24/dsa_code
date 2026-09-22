public class StackProblems {
    //remove adjacent duplicate element in string
    public String removeDuplicates(String s) {
        StringBuilder stk = new StringBuilder();
        for(char c : s.toCharArray()){
            int len = stk.length();
            if( len >0 && stk.charAt(len - 1) == c){
                stk.deleteCharAt(len -1);
            }else {
                stk.append(c);
            }
        }
        return stk.toString();
    }
}
