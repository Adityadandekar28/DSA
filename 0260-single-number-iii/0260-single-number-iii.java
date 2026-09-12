class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xored =0;
        for(int num : nums){
            xored ^= num;
        }

        int exbit =0;
        while(true){
            if((xored & 1)==1){
                break;
            }
            xored=xored >>1;
            exbit ++;
        }
        int setBucket =0;
        int unsetBucket=0;
        for(int num : nums){
            if((num >> exbit & 1)==1){
                setBucket ^= num;
            }else{
                unsetBucket ^= num;
            }
            
        }
        return new int[] {setBucket ,unsetBucket};
    }
}