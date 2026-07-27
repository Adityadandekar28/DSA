class Solution {
    public boolean isAnagram(String s, String t) {
       int s1= s.length();
        int s2= t.length();
        int[] arr1= new int[100];
        int[] arr2= new int[100];


        if(s1!=s2){
            return false;
        }
        for(int i=0;i<s1; i++){
            arr1[s.charAt(i)-'a']++;
            arr2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<arr1.length; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}