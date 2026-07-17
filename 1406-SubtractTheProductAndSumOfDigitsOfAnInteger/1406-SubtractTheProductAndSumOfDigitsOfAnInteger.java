// Last updated: 7/17/2026, 3:15:03 PM
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return product - sum;
    }
}