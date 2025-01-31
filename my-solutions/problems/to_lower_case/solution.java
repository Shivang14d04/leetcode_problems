class Solution {
    public String toLowerCase(String s) {
     char [] arr = new char[s.length()];
     for(int i = 0;i< s.length();i++){
        arr[i]  =s.charAt(i);
     }
     for(int  i =0;i<s.length();i++){
        if(arr[i]<='Z'&& arr[i]>='A'){
            arr[i]+=32;
        }
     } 
     return new String(arr)  ;
    }
}