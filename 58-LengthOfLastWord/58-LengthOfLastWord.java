// Last updated: 7/17/2026, 3:16:11 PM
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;

        
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }

        return len;
    }
}