import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
    static boolean brackets(String expr) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String expr = "{([}}])";

        if (brackets(expr)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        String expr1 = "{([])}";

        if(brackets(expr1)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
//runtime complexity 0(n)