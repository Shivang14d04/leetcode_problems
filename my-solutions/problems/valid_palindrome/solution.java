class Solution {
    public boolean isPalindrome(String s) {
        char [] arr = s.toCharArray();
        StringBuilder string = new StringBuilder();

        for(int i =0;i< arr.length;i++){
            if((arr[i]>='A' && arr[i]<='Z') || (arr[i]>='0' && arr[i]<='9')){
                arr[i]= Character.toLowerCase(arr[i]);
                string.append(arr[i]);
            }
            else if(arr[i]<'A' ||(arr[i]>'Z'&& arr[i]<'a')||arr[i]>'z'){
                continue;
            }
            else{
                string.append(arr[i]);
            }
        }
        if(string.toString().equals(string.reverse().toString())){
            return true;
        }
        return false;
    }
}