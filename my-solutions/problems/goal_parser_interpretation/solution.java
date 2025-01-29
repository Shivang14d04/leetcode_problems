class Solution {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        
        for(int i =0; i< command.length();i++){
            char c = command.charAt(i);
            if(c=='G'){
                result.append('G');
            }
            else if(c=='('){
                if(command.charAt(i+1) ==')'){
                result.append('o');
                i++;
                }
                else{
                    result.append("al");
                    i=i+3;
                }


            }
        }

        
        return result.toString();
        
    }
}