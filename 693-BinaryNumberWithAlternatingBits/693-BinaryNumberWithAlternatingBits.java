// Last updated: 7/17/2026, 3:15:14 PM
class Solution {
    public boolean hasAlternatingBits(int n) {
         n = n ^ (n>>1);
        return (n & n+1) == 0;
        
    }
}