import java.util.Scanner;
class SmallestLetterGreaterThanTarget{
    public static void main (String [] args){

        char [] letters  ={'c','f','j'};
        Scanner input = new Scanner(System.in);
        char target  = input.next().charAt(0);
        char final_answer = answer(letters, target);
        System.out.println(final_answer);

    }
    public static char answer(char [] letters , char target){
        int start = 0;
        int end = letters.length-1;
        char ans = letters[0];
        while(start<=end ){
            int mid = start + (end -start)/2;
            if(letters[mid]>target){
                ans = letters[mid];
                end  = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }
}