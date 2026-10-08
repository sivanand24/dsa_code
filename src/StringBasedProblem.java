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
}
