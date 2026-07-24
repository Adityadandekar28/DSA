class Solution {
    public boolean isSubsequence(String s, String t) {
       int j=0;
       int count=0;
       if(s.length()==0 ){
        return true;
       }
       for(int i=0;i<t.length();i++){
        if(s.charAt(j)==t.charAt(i)){
               count++;
        
        if(count==s.length()){
            return true;
        }
        j++;
        }
       } 
       return false;
    }
}