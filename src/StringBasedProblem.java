import java.util.HashMap;

public class StringBasedProblem {
    //ramson note problem
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(char c : magazine.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(count[c - 'a'] == 0){
                return false;
            }
            count[c - 'a']--;
        }
        return true;
    }
    //find unique character in the string
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(int i = 0; i <s.length(); i++){
            if(count[s.charAt(i) - 'a']== 1){
                return i;
            }
        }
        return -1;
    }
    //length of the last word
    public int lengthOfLastWord(String s) {
        int i = s.length() -1;
        while( i>=0 && s.charAt(i) == ' '){
            i--;
        }
        int j = i;
        while( j>=0 && s.charAt(j) != ' '){
            j--;
        }
        return i -j;
    }
    // Roman to Integer
    public int romanToInt(String s) {
        HashMap<Character ,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int total = 0;
        for(int i = 0; i < s.length(); i++){
            if(i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                total = total - map.get(s.charAt(i));
            }
            else {
                total = total + map.get(s.charAt(i));
            }
        }

        return total;
    }
    //2697. Lexicographically Smallest Palindrome
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length -1;
        while(i <j){
            cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
            i++;
            j--;
        }
        return new String(cs);
    }
}
