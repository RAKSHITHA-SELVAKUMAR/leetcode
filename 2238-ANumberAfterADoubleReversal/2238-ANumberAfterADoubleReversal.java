// Last updated: 7/17/2026, 3:14:58 PM
class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0)
            return true;
        return num % 10 != 0;
        
    }
}