class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[0],a[0]));
        for(int [] num : points){
            int dis = findDis(num);
            pq.add(new int[]{dis,num[0],num[1]});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int [][] ans =new int[k][2];
        int i =0;
        while(!pq.isEmpty()){
            int [] temp  = pq.poll();
            ans[i][0] = temp[1];
            ans[i][1] = temp[2];
            i++;
        }
        return ans;

    }
    public int findDis(int [] arr){
        int x = arr[0], y = arr[1];
        return x*x + y*y ;
    }
}