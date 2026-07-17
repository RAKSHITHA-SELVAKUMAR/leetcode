// Last updated: 7/17/2026, 3:15:08 PM
class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int min = -1,l = 1,h = 25_000_000;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(check(mid,days,arr)){
                min = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return min;
    }
    private boolean check(int capacity,int days,int[] arr){
        int daysCnt = 0,currCapacity = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > capacity){
                return false;
            }
            currCapacity += arr[i];
            if(currCapacity > capacity){
                daysCnt++;
                currCapacity = arr[i];
            }
        }
        if(currCapacity <= capacity){
            daysCnt++;
        }
        return daysCnt <= days;
    }
}