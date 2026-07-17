// Last updated: 7/17/2026, 3:14:57 PM
class Solution {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        return n % 2 > 0 ? n : n / 2;
    }
}