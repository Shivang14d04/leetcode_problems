public class GoalParserInterpretation{
    public static void main(String [] args){
        String command = "G()(al)";
        StringBuilder result = new StringBuilder();
        for(int i =0;i< command.length();i++){
            if(command.charAt(i)=='G'){
                result.append('G');
            }
            else if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')'){
                    result.append('o');
                    i++;
                }
                else{
                    result.append("al");
                    i=i+3;
                }
            }
        }
        System.out.println(result.toString());
    }
}