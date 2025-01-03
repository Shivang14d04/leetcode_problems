import java.util.*;
public class AverageSalaryExcludingTheMinAndMax{
    public static void main(String[] args) {
        int salary [] = {4000,3000,1000,2000};
        double ans = solution(salary);
        System.out.println(ans);

    }
    public static double solution(int salary []){
        Arrays.sort(salary);
        double count = salary.length-2;
        double sum =0;
      for(int i =1;i< salary.length-1;i++){
        sum+=salary[i];
      }
      double average = sum/count;  
      
      return average;        
    }
}