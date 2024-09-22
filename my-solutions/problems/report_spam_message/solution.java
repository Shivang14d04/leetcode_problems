class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
    HashMap<String,Integer> map = new HashMap<>();
    for(int i =0;i<bannedWords.length;i++){
        map.put(bannedWords[i],1);
    }
    int ans = 0;
    for( int i = 0;i<message.length;i++){
        if(map.containsKey(message[i])){
            ans++;
        }
        if(ans>=2){
            return true;
        }
    }
    return false;
    }
}