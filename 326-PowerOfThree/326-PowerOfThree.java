// Last updated: 7/17/2026, 3:15:27 PM
class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n==1)
         return true;
        
        if(n<1)
            return false;

        
        while(n%3==0){
            n=n/3;
        }
        if(n==1)
            return true;
        
        else
            return false;
        
        
    }
}

