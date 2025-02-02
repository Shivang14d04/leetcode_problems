public class RobotReturnToOrigin{
    public static void main(String[] args){
        String moves = "UDD";
        String moves1 = moves;
        System.out.println(solution(moves1));

    }
    public static boolean solution(String moves){
        char [] ans = moves.toCharArray();
        int cnt_U =0;
        int cnt_D =0;
        int cnt_L = 0;
        int cnt_R = 0;
        if(moves.length()%2!=0){
            return false;
        }
        else{
            for(int i = 0;i< ans.length;i++){
                if(ans[i]=='D'){
                    cnt_D++;
                }
                else if(ans[i]=='U'){
                    cnt_U++;
                }
                else if(ans[i]=='L'){
                    cnt_L++;
                }
                else{
                    cnt_R++;
                }  
            }

        }
        if(cnt_U == cnt_D && cnt_L==cnt_R){
            return true;
        }
        else{
            return false;
        }        
    }
}