
    public int firstBadVersion(int n) {
        int s = 1;
        int e = n;
        
        while(s<e){
             int mid = s + (e-s)/2;
            if(isBadVersion(mid)==true){
                e = mid -1;
            }
            else if(isBadVersion(mid)==false) {
                s = mid+1;
            }
            
        }
        return s;
    
    }
