public class BalancedParentheses {
    public static boolean isBalanced(String exp){
       boolean flag = true;
       int count = 0;

       for(int i =0; i < exp.length(); i++){
           if(exp.charAt(i) == '('){
               count++;
           } else {
               count--;
           }
           if(count < 0){
               flag = false;
               break;
           }
       }
       if(count != 0){
           flag = false;
       }
       return flag;
    }

    public static void main(String[] args){
        String exp1 = "((()))()";

        if(isBalanced(exp1)){
            System.out.println("True");;
        } else {
            System.out.println("False");
        }

        String exp2 = ")()()(";

        if(isBalanced(exp2)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

//runtime complexity 0(n)