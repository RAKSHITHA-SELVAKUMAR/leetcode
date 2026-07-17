// Last updated: 7/17/2026, 3:15:28 PM
class Solution {
    
    int BIT[];
    public List<Integer> countSmaller(int[] nums) {
       
        
        int n=nums.length;
         
        ArrayList<Integer>ll=new ArrayList<>();
        TreeSet<Integer>set=new TreeSet<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int a:nums){
            set.add(a);
        }
        int k=1;
        for(int a:set){
            map.put(a,k);
            k++;
        }
        for(int i=0;i<n;i++){
            int a=nums[i];
            nums[i]=map.get(a);
        }
        BIT=new int[n+2];
        for(int i=n-1;i>=0;i--){
            ll.add(query(nums[i]-1));
            update(nums[i],1,n);
        }
         Collections.reverse(ll);
        return ll;
    }
    public void update(int idx,int val,int n){
        while(idx<=n){
            BIT[idx]+=val;
            idx+=(idx&-idx);
        }
    }
    public int query(int idx){
        int ans=0;
        while(idx>0){
            ans+=BIT[idx];
            idx-=(idx&-idx);
        }
        return ans;
    }
}