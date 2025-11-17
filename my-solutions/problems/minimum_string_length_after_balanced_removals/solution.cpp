class Solution {
public:
    int minLengthAfterRemovals(string s) {
    int n=s.length();
    int c1=0;int c2=0;
    for(int i=0;i<n;i++){
        if(s[i]=='a')c1++;
        else c2++;
    }
    return abs(c1-c2);
    }
};